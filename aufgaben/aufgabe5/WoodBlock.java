
// Der Luftblock. 
// Wird verwendet falls kein anderer Block mehr vorhanden ist.
public class WoodBlock extends Block {

    public WoodBlock() {

    }

    @Override
    public Block copy() {
        return new WoodBlock();
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public int hardness() {
        return 4;
    }


}
