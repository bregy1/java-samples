
// Der Luftblock. 
// Wird verwendet falls kein anderer Block mehr vorhanden ist.
public class WorldBorderBlock extends Block {

    // Eine Entwicklerfreundliche kurze Beschreibung was der Block darstellt.
    private static final String DESCRIPTION = "Represents World border which surrounds the map";

    // Standard Konstruktor. Am besten immer erfassen.
    public WorldBorderBlock() {

    }

    // Kopiert den Block. Erstellt eine neue Referenz mit denselben
    // Daten. Wichtig für den Welt Generator. Der Generator kennt nur die Basisklasse "Block". 
    @Override
    public Block copy() {
        return new WorldBorderBlock();
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
