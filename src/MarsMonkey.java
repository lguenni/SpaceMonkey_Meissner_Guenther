import processing.core.PApplet;
import processing.core.PImage;

public class MarsMonkey extends Monkey{

    PImage marsMonkeyImage = null;
    PImage[] frames = null;

    public MarsMonkey(ISpielWelt welt, int posX, int posY) {
        super(welt,posX, posY);
    }

    /**
     * Überschreibt die Methode "zeichne" und zeichnet einen MarsMonkey
     */
    @Override
    public void zeichne(PApplet app) {
        //app.pushStyle();
        //app.fill(230, 15, 15);
        //app.rect(posX, posY, breite, hoehe);
        //app.popStyle();
        //if (marsMonkeyImage == null) {
          //  marsMonkeyImage = app.loadImage("ressources/monkeywin2.png");
        //}
        //app.image(marsMonkeyImage,posX, posY, breite, hoehe);
        loadFrames(app);

    }

    private void loadFrames(PApplet app) {
        if (frames == null) {
            this.frames = loadFrames(app,"ressources/MarsMonkey/frame-%d.png",1);
        }
    }


}
