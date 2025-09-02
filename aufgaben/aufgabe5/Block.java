


// Basis Klasse für Block
// Definiert einige Klassen die von den Erbenden Klassen implementiert werden müssen!.
// andere können müssen aber nicht überschrieben werden.
public abstract class Block {

    // Kopiert den Block. Erstellt eine neue Referenz mit denselben
    // Daten. Wichtig für den Welt Generator. Der Generator kennt nur die Basisklasse "Block". 
    public abstract Block copy();


    // Gibt an ob man auf einem Block stehen kann,
    public abstract boolean isSolid();

    // Die Härte des BLocks. Gebraucht um zu entscheiden ob ein TOol den BLock abbauen kann.
    public int hardness() {
        return 0;
    }


}


