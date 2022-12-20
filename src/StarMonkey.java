import processing.core.PApplet;
import processing.core.PImage;

public class StarMonkey extends Monkey{

    PImage starMonkeyImage = null;

    public StarMonkey(ISpielWelt welt,int posX, int posY) {
        super(welt,posX, posY);
    }

    /**
     * Überschreibt die Methode "zeichne" und zeichnet einen StarMonkey
     */
    @Override
    public void zeichne(PApplet app) {
       // app.pushStyle();
        //app.fill(230, 200, 15);
        //app.rect(posX, posY, breite, hoehe);
        //app.popStyle();
        if (starMonkeyImage == null) {
           starMonkeyImage = app.loadImage("ressources/StarMonkey1.png");
        }
        app.image(starMonkeyImage,posX, posY, breite, hoehe);
    }


}
