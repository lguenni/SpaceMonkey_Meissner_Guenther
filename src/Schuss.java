import processing.core.PApplet;

public class Schuss extends Spielobjekt{

    public Schuss(int posX, int posY) {
        super(posX, posY, 10,6);
    }

    int Geschwindigkeit;

    /**
     * Bewegt den Schuss mit der Geschwindigkeit nach oben
     */
    public void bewege(){
        posY = posY + Geschwindigkeit;
    }


    public void zeichne(PApplet app) {
        app.pushStyle();
        app.fill(10, 10, 10);
        app.rect(posX, posY, breite, hoehe);
        app.popStyle();
    }
}
