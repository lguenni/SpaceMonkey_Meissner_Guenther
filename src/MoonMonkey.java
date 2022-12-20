import processing.core.PApplet;
import processing.core.PImage;

public class MoonMonkey extends Monkey{

    PImage moonMonkeyImage = null;

    public MoonMonkey(ISpielWelt welt,int posX, int posY) {
        super(welt,posX, posY);
    }
    /**
     * Überschreibt die Methode "zeichne" und zeichnet einen MoonMonkey
     */
    @Override
    public void zeichne(PApplet app) {
        //app.pushStyle();
        //app.fill(200, 100, 100);
        //app.rect(posX, posY, breite, hoehe);
        //app.popStyle();

        if (moonMonkeyImage == null) {
            moonMonkeyImage = app.loadImage("ressources/MoonMonkey1.png");
        }
        app.image(moonMonkeyImage,posX, posY, breite, hoehe);
    }

    @Override
    public void bewege(){
        posX = posX - 1;

        if(this.getPosX() <= 0){
            this.setPosX(600 - this.getBreite());
        }
    }
}
