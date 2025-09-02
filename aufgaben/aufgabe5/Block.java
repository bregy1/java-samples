


// Basis Klasse für Block
// Definiert einige Klassen die von den Erbenden Klassen implementiert werden müssen!.
// andere können müssen aber nicht überschrieben werden.
public abstract class Block {

    // Eine ID bzw. Typs des Blocks. 
    // Beispiel: water, dirt etc.
    public abstract String getId();

    // Kopiert den Block. Erstellt eine neue Referenz mit denselben
    // Daten. Wichtig für den Welt Generator
    public abstract Block copy();


}


