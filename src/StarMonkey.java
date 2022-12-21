import processing.core.PApplet;
import processing.core.PImage;

public class StarMonkey extends Monkey{

    PImage[] frames = null;

    public StarMonkey(ISpielWelt welt,int posX, int posY) {
        super(welt,posX, posY);
    }

    /**
     * Überschreibt die Methode "zeichne" und zeichnet einen StarMonkey
     */
    @Override
    public void zeichne(PApplet app) {
        loadFrames(app);

        app.image(frames[0], posX, posY, breite, hoehe);
    }

    public void loadFrames(PApplet app){
        if (frames == null) {
            this.frames = loadFrames(app,"ressources/StarMonkey/frame-%d.png", 2);
        }
    }
}
