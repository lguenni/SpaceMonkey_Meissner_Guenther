import processing.core.PApplet;
import processing.core.PImage;

import java.util.Random;

public class Meteorit extends Spielobjekt {

    PImage[] frames = null;

    int geschwindigkeit =2;

    public Meteorit(ISpielWelt welt, int posX, int posY) {
        super(welt, posX, posY, 40, 120);
    }

    public int randomGeschwindigkeitMeteorit(){
        Random r = new Random();
        return r.nextInt(5)+1;

    }

    public int randomHoeheMeteorit(){
        Random r = new Random();
        return r.nextInt(201)+350;

    }



    public void bewege(){
     posX = posX + geschwindigkeit;
        if(this.getPosX() >= 600 - this.getBreite()){
            geschwindigkeit = randomGeschwindigkeitMeteorit();
            this.setPosX(0);
            this.setPosY(randomHoeheMeteorit());
        }

    }

    public void zeichne(PApplet app) {
        loadFrames(app);

        int frameIndex =  Math.abs((welt.getVerbleibendeZeit() /10) %3);

        app.image(frames[frameIndex], posX, posY, breite, hoehe);
    }

    public void loadFrames(PApplet app){
        if (frames == null) {
            this.frames = loadFrames(app,"ressources/Meteor/frame-%d.png", 3);
        }
    }


}
