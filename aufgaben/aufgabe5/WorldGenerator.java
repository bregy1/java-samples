
import java.util.Random;

public class WorldGenerator {

    // Eine Grundliste von Blöcken die für die Generierung vorgeseehn wird.
    // Hier kommt jeder bekannte Block Typ einmal rein. 
    // Es können auch meheree des selben Typs eingefügt werden. Somit erhöht sich die
    // Chance dass er öfters auftritt.
    private final Block[] templateBlocks;

    // Zufalls Generator von Java
    private final Random rnd;

    public WorldGenerator(Block[] templateBlocks) {
        this.templateBlocks = templateBlocks;
        this.rnd = new Random();
    }

    private Block randomBlock() {
        // Generiert eine zufällige Zahl welche in der Array range bleibt.
        int randomNum = this.rnd.nextInt(this.templateBlocks.length);
        return this.templateBlocks[randomNum].copy();
    }

    // Erstellt eine leere Welt mit zufällig eingefüllten Blöcken.
    // Die Welt grösse ist ein Quadrat mit size * size Grösse
    public Block[][] generate(int size) {
        Block[][] terrain = new Block[size][size];

        System.out.println("generate world with size " + size + " * " + size);
        for (int i = 0; i < size; i++) {

            // Erstellung von einer Horizontalen Line in unserere Welt.
            // Es werden für die in size definierte Anzahl Blöcke generiert Pro Linie
            Block[] layer = new Block[size];

            for (int j = 0; j < size; j++) {
                layer[j] = this.randomBlock();
            }

            // Store one line of blocks.
            terrain[i] = layer;

        }

        return terrain;

    }

}
