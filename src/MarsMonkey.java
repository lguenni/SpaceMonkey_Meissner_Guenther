import processing.core.PApplet;
import processing.core.PImage;

public class MarsMonkey extends Monkey{

    PImage[] frames = null;
    int frameIndex = 0;

    public MarsMonkey(ISpielWelt welt, int posX, int posY) {
        super(welt,posX, posY);
    }

    /**
     * Überschreibt die Methode "zeichne" und zeichnet einen MarsMonkey
     */
    @Override
    public void zeichne(PApplet app) {
        loadFrames(app);


        int frameIndex =  Math.abs((welt.getVerbleibendeZeit() / 1000) % 2);


        app.image(frames[frameIndex], posX, posY, breite, hoehe );

    }

    private void loadFrames(PApplet app) {
        if (frames == null) {
            this.frames = loadFrames(app,"ressources/MarsMonkey/frame-%d.png", 2);
        }
    }


}
