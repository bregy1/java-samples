
// Der Luftblock. 
// Wird verwendet falls kein anderer Block mehr vorhanden ist.
public class AirBlock extends Block {

    private static final String DESCRIPTION = "Represents empty space.";

    public AirBlock() {

    }

    @Override
    public Block copy() {
        return new AirBlock();
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
