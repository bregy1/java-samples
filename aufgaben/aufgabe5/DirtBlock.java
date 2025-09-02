
// Der Luftblock. 
// Wird verwendet falls kein anderer Block mehr vorhanden ist.
public class DirtBlock extends Block {

    public DirtBlock() {

    }

    @Override
    public Block copy() {
        return new DirtBlock();
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
