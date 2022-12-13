import processing.core.PApplet;

public class StarMonkey extends Monkey{

    public StarMonkey(ISpielWelt welt,int posX, int posY) {
        super(welt,posX, posY);
    }

    /**
     * Überschreibt die Methode "zeichne" und zeichnet einen StarMonkey
     */
    @Override
    public void zeichne(PApplet app) {
        app.pushStyle();
        app.fill(230, 200, 15);
        app.rect(posX, posY, breite, hoehe);
        app.popStyle();
    }


}
