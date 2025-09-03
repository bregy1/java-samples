
// Der Luftblock. 
// Wird verwendet falls kein anderer Block mehr vorhanden ist.
public class WaterBlock extends Block {

    public WaterBlock() {

    }

    @Override
    public Block copy() {
        return new WaterBlock();
    }

    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public int hardness() {
        return 99999;
    }


}
