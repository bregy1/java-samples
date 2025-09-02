public class Main {

    public static void main(String[] args) {

        // world generation
        Block[] uniqueBlocks = new Block[]{
            new DirtBlock(),
            new DirtBlock(),
            new SandBlock(),
            new WoodBlock()
        };

        WorldGenerator generator = new WorldGenerator(uniqueBlocks);
        World world = World.generate(generator);

        // gameplay ^^
        Player player1 = new Player("bregy");
        player1.JoinWorld(world);

        player1.showBlock(Direction.BOTTOM);
        player1.move(Direction.BOTTOM);
        player1.showBlock(Direction.BOTTOM);

        player1.collectBlock(Direction.BOTTOM);
player1.collectBlock(Direction.BOTTOM); 















    }
}