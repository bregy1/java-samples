
public class Main {

    public static void main(String[] args) {

        // world generation
        Block[] uniqueBlocks = new Block[]{
            new DirtBlock(),
            new SandBlock(),
            new WoodBlock()
        };

        WorldGenerator generator = new WorldGenerator(uniqueBlocks);
        World world = World.generate(generator);
        world.print();

        Player player1 = new Player("bregy");
        player1.JoinWorld(world);
        world.print();

        player1.move(Direction.BOTTOM);
        player1.move(Direction.BOTTOM);
        player1.move(Direction.BOTTOM);

        world.print();

        player1.move(Direction.TOP);
        player1.move(Direction.LEFT);
        player1.collectBlock(Direction.LEFT);

        player1.move(Direction.TOP);
        world.print();

        player1.collectBlock(Direction.LEFT);
        player1.collectBlock(Direction.LEFT);
        player1.printInventory();
    }
}
