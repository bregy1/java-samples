
import java.util.HashMap;

// Managed das Terrain im Spiel. Die Welt ist hier im Beispiel nur 2d. Vorstellbar in
// der Vogelperspektive. Ein Spieler kann also nur nach Norden, Süden, Westen oder Osten laufen.
public class World {


    public static final int WORLD_SIZE = 12;
    public static final String WORLD_NAME = "mc-ultimate";

    private static World instance = null;

    private Block[][] terrain;
    private HashMap<String, Player> players = new HashMap();

    // privater Konstruktor. Nur in der World Klasse aufrufbar.
    private World(Generator generator) {
        System.out.println("Create world \"" + World.WORLD_NAME + "\"");
        this.terrain = generator.generate(World.WORLD_SIZE);
    }

    // Helfer Methode um die Referenz zur einzigen Welt zu erhalten. 
    // Wirft eine Exception falls die Welt noch nicht generiert wurde.
    public static World getWorld() {
        if (World.instance == null) {
            throw new IllegalStateException("World needs to be generated first.");
        }
        return World.instance;
    }

    // Von Aussen zugängliche Methode um eine Referenz zur Welt zu erhalten. 
    // Durch einen privaten Konstruktor und diese statische Methode wird sichergestellt
    // dass nie mehr als eine einzige Welt existiert.
    public static World generate(Generator generator) {
        if(World.instance != null) {
            throw new IllegalStateException("World can only be generated once.");
        }
        World.instance = new World(generator);
        return World.instance;
    }

    public void join(Player player) {
        this.players.put(player.getName(), player);
        System.out.println("Player " + player.getName() + "");
    }

}
