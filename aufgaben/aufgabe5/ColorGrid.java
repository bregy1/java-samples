
import java.util.HashMap;

public class ColorGrid {

    // Reset
    public static final String RESET = "\u001B[0m";

    // Colors
    public static final String BG_RED = "\u001B[41m";
    public static final String BG_GREEN = "\u001B[42m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_YELLOW = "\u001B[43m";
    public static final String BG_CYAN = "\u001B[46m";
    public static final String BG_WHITE = "\u001B[47m";
    public static final String BG_BLACK = "\u001B[40m";

    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String BLACK = "\u001B[30m";

    public static String getColor(Block block) {

        if (block.isSolid()) {
            return ColorGrid.GREEN;
        }

        if (block.hardness() > 1000) {
            return ColorGrid.BLACK;
        }

        return ColorGrid.WHITE;

    }

    private void PrintRowCoordinates(Block[][] terrain) {
        System.out.print("  ");
        // Oberste Koordinatenreihe schreiben
        for (int i = 0; i < terrain[0].length; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();

    }

    private boolean[][] buildPlayerMap(Block[][] terrain, HashMap<String, int[]> playerCoords) {
        // erstelle eine Spielerkarte zum einfachen nachschauen
        // Wir setzen "true" falls ein Spieler auf einem Quadrat steht!
        boolean[][] playerMap = new boolean[terrain.length][terrain[0].length];
        playerCoords.forEach((key, coords) -> {
            playerMap[coords[0]][coords[1]] = true;
        });
        return playerMap;
    }

    public void print(Block[][] terrain, HashMap<String, int[]> playerCoords) {
        // Speichere Player in Block

        // Edge case abfangen..
        if (terrain.length == 0 || terrain[0].length == 0) {
            System.out.println("Cannot draw map. Invalid or empty terrain");
            return;
        }

        boolean[][] playerMap = this.buildPlayerMap(terrain, playerCoords);
        this.PrintRowCoordinates(terrain);

        for (int i = 0; i < terrain.length; i++) {
            
            // Kolonnen nummer ausgeben für Koordinaten Grid
            System.out.print("" + i);

            // Row
            for (int j = 0; j < terrain[i].length; j++) {                
                String color = getColor(terrain[i][j]);

                // Für Spieler ein x zeichnen
                if (playerMap[i][j]) {
                    System.out.print( ColorGrid.RED + " x " + RESET);
                } else {
                    System.out.print(color + " ■ " + RESET);
                }
            }

            System.out.println();
        }
    }

}
