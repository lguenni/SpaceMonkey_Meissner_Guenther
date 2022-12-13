import processing.core.PApplet;

public class MarsMonkey extends Monkey{

    public MarsMonkey(ISpielWelt welt, int posX, int posY) {
        super(welt,posX, posY);
    }

    /**
     * Überschreibt die Methode "zeichne" und zeichnet einen MarsMonkey
     */
    @Override
    public void zeichne(PApplet app) {
        app.pushStyle();
        app.fill(230, 15, 15);
        app.rect(posX, posY, breite, hoehe);
        app.popStyle();
    }


}
