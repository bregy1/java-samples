
import java.util.HashMap;

// Managed das Terrain im Spiel. Die Welt ist hier im Beispiel nur 2d. Vorstellbar in
// der Vogelperspektive. Ein Spieler kann also nur nach Norden, Süden, Westen oder Osten laufen.
public class World {

    // Welt Konfiguration
    private static final int WORLD_SIZE = 5;
    private static final int MAX_SLOTS = 2;
    private static final String WORLD_NAME = "mc-ultimate";

    // Wird verwendet falls kein anderer Block an einer Stelle gefunden wird.
    private static final Block PLACEHOLDER_BLOCK = new AirBlock();
    private static final Block WORLD_BORDER_BLOCK = new WorldBorderBlock();

    private static World INSTANCE = null;

    // Used to print an overview of the map :)
    private final ColorGrid colorGrid = new ColorGrid();

    // terrain spiegelt die Grösse wieder
    // terrain ist eine Fixe Grösse darum Array.
    private final Block[][] terrain;

    // Speichert die Spieler Koordinaten. 
    // Map verwenden um einfach via des Spielers ID auf die Koordinaten zugreifen zu können.
    // Empfehlung hier eine String ID zu verwenden. Damit ist die Suche weniger mit dem Spieler
    // Objekt gekoppelt. Es könnten Beispielsweise Tiere hinzugefügt werden welche 
    // auch via ID gefunden werden können.
    private final HashMap<String, int[]> playerCoords = new HashMap<>();

    // Hashmap verwenden um einfachen zugriff auf eine Spieler Liste via ID zu ermöglichen.
    private final HashMap<String, Player> players = new HashMap<>();

    // privater Konstruktor. Nur in der World Klasse aufrufbar.
    private World(WorldGenerator generator) {
        System.out.println("Create world \"" + World.WORLD_NAME + "\"");
        this.terrain = generator.generate(World.WORLD_SIZE);
    }

    // Helfer Methode um die Referenz zur einzigen Welt zu erhalten. 
    // Wirft eine Exception falls die Welt noch nicht generiert wurde.
    public static World getWorld() {
        if (World.INSTANCE == null) {
            throw new IllegalStateException("World needs to be generated first.");
        }
        return World.INSTANCE;
    }

    // Von Aussen zugängliche Methode um eine Referenz zur Welt zu erhalten. 
    // Durch einen privaten Konstruktor und diese statische Methode wird sichergestellt
    // dass nie mehr als eine einzige Welt existiert.
    public static World generate(WorldGenerator generator) {
        if (World.INSTANCE != null) {
            throw new IllegalStateException("World can only be generated once.");
        }
        World.INSTANCE = new World(generator);
        return World.INSTANCE;
    }

    // setzt den Spieler in die Spielmitte. 
    // 0-0 ist oben links. Die Mitte wird ausgerechnet.
    public void spawn(Player player) {
        if (this.players.size() >= World.MAX_SLOTS) {
            throw new IllegalStateException("Player cannot join the world: world is full. Slots: " + World.MAX_SLOTS);
        }

        // Java rundet das Ergebnis automatisch auf die kleinere Zahl
        // weil wir mit Integeren (ganzzahlen) arbeiten
        int middle = World.WORLD_SIZE / 2;
        System.out.println("Spawn player \"" + player.getName() + "\" at " + middle + ':' + middle);
        int[] coords = new int[]{middle, middle};

        // Spieler positionieren und referenz zum Spieler Speichern
        this.playerCoords.put(player.getId(), coords);
        this.players.put(player.getId(), player);
    }

    public void printPlayers() {
        System.out.println("Total of " + this.players.size() + " online");
        this.players.forEach((id, player) -> {
            System.out.println(player.getName());
        });
    }

    private boolean areCoordsInTerrain(int[] coords) {
        int y = coords[0];
        int x = coords[1];

        // überprüfen ob diese Koordinaten sich in unserer Welt befinden
        if (x < 0 || x > (World.WORLD_SIZE - 1)) {
            return false;
        }

        if (y < 0 || y > (World.WORLD_SIZE - 1)) {
            return false;
        }

        return true;

    }

    // Es muss zuerst überprüft werden ob die Koordinaten in "coords" im Raster liegen.
    // Danach wird entweder ein Block ODER ein WorldBorder Block zurückgegeben. Dieser Repräsentiert das "nichts"
    private Block getBlockAt(int[] coords) {
        int y = coords[0];
        int x = coords[1];

        if (!this.areCoordsInTerrain(coords)) {
            return World.WORLD_BORDER_BLOCK.copy();
        }

        return this.terrain[y][x];

    }

    public Block showNextBlock(String playerId, Direction direction) {
        int[] coords = this.playerCoords.get(playerId);
        int[] newCoords = this.moveCoordsIntoDirection(coords, direction);
        return this.getBlockAt(newCoords);
    }

    private String coordsToString(int[] coords) {
        return coords[0] + ":" + coords[1];
    }

    public Block collectBlock(Player player, Direction direction) {
        int[] coords = this.playerCoords.get(player.getId());
        int[] newCoords = this.moveCoordsIntoDirection(coords, direction);
        Block block = this.getBlockAt(newCoords);

        // erlaubt das sammeln des Blocks.
        if (!player.getTool().canCollect(block)) {
            System.out.println("block " + block.getClass() + " cannot be collected by " + player.getTool().getClass());
            return null;
        }

        System.out.println("collect block at " + this.coordsToString(newCoords) + " " + block.getClass());

        int y = newCoords[0];
        int x = newCoords[1];

        // Setze einen Placeholder block and die Stelle.
        this.terrain[y][x] = World.PLACEHOLDER_BLOCK;

        return block;
    }

    public void print() {
        this.colorGrid.print(this.terrain, this.playerCoords);
    }

    private int[] moveCoordsIntoDirection(int[] coords, Direction direction) {
        int y = coords[0];
        int x = coords[1];

        // Je nach RIchtung die x und y koordinaten des Spielers verändern.
        // Der Spieler bewegt sich hier immer um 1 Block.
        if (direction == Direction.TOP) {
            y -= 1;
        } else if (direction == Direction.BOTTOM) {
            y += 1;
        } else if (direction == Direction.LEFT) {
            x -= 1;
        } else if (direction == Direction.RIGHT) {
            x += 1;
        }

        return new int[]{y, x};
    }

    public boolean movePlayer(String playerId, Direction direction) {
        int[] coords = this.playerCoords.get(playerId);
        int[] newCoords = this.moveCoordsIntoDirection(coords, direction);

        if (!this.areCoordsInTerrain(newCoords)) {
            System.out.println("Cannot move " + direction.toString() + " -> World border reached at" + this.coordsToString(coords));
            return false;
        }

        Block block = this.getBlockAt(newCoords);
        if (!block.isSolid()) {
            System.out.println("Cannot move " + direction.toString() + "-> Block is not solid" + this.coordsToString(coords) + " block type " + block.getClass());
            return false;
        }

        System.out.println("move player to " + this.coordsToString(newCoords));
        // Target Block im Terrain und solide! Neue Koordinaten setzen.
        this.playerCoords.put(playerId, newCoords);

        return true;
    }

}
