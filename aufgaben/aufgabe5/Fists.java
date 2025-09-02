public class Fists extends Tool {
    @Override
    public boolean canCollect(Block block) {
        return block.hardness() < 5;
    }
}