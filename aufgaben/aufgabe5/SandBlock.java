
// Der Luftblock. 
// Wird verwendet falls kein anderer Block mehr vorhanden ist.
public class SandBlock extends Block {

    public SandBlock() {

    }

    @Override
    public Block copy() {
        return new SandBlock();
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public int hardness() {
        return 2;
    }


}
