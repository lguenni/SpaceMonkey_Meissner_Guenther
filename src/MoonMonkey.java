import processing.core.PApplet;
import processing.core.PImage;

public class MoonMonkey extends Monkey{

    PImage[] frames = null;

    public MoonMonkey(ISpielWelt welt,int posX, int posY) {
        super(welt,posX, posY);
    }
    /**
     * Überschreibt die Methode "zeichne" und zeichnet einen MoonMonkey
     */
    @Override
    public void zeichne(PApplet app) {
        loadFrames(app);

        int frameIndex =  welt.getVerbleibendeZeit() % 2;
        app.image(frames[frameIndex], posX, posY, breite, hoehe);
    }

    public void loadFrames(PApplet app){
        if (frames == null) {
            this.frames = loadFrames(app,"ressources/MoonMonkey/frame-%d.png", 2);
        }
    }

    @Override
    public void bewege(){
        posX = posX - 1;

        if(this.getPosX() <= 0){
            this.setPosX(600 - this.getBreite());
        }
    }
}
