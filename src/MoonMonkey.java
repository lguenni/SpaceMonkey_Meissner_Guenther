import processing.core.PApplet;
import processing.core.PImage;

public class MoonMonkey extends Monkey{

    PImage[] frames = null;

    public MoonMonkey(ISpielWelt welt,int posX, int posY) {
        super(welt,posX, posY);
    }

    /**
     * Überschreibt die Methode "zeichne" und zeichnet einen animierten MoonMonkey.
     */
    @Override
    public void zeichne(PApplet app) {
        loadFrames(app);

        int frameIndex =  Math.abs((welt.getVerbleibendeZeit() / 1000) % 2);
        app.image(frames[frameIndex], posX, posY, breite, hoehe);
    }

    /**
     * Lädt die Frames des MarsMonkeys einmalig.
     */
    public void loadFrames(PApplet app){
        if (frames == null) {
            this.frames = loadFrames(app,"ressources/MoonMonkey/frame-%d.png", 2);
        }
    }

    /**
     * MoonMonkey bewegt sich in eine andere Richtung.
     */
    @Override
    public void bewege(){
        posX = posX - 1;

        if(this.getPosX() <= 0){
            this.setPosX(600 - this.getBreite());
        }
    }
}
