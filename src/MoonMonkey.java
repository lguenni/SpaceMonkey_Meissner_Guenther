import processing.core.PApplet;

public class MoonMonkey extends Monkey{

    public MoonMonkey(int posX, int posY) {
        super(posX, posY);
    }
    /**
     * Überschreibt die Methode "zeichne" und zeichnet einen MoonMonkey
     */
    @Override
    public void zeichne(PApplet app) {
        app.pushStyle();
        app.fill(200, 100, 100);
        app.rect(posX, posY, breite, hoehe);
        app.popStyle();
    }
}
