import processing.core.PApplet;
import processing.core.PImage;

public class Apollo404 extends Spielobjekt {


    PImage raumschiffImage = null;

    public Apollo404(ISpielWelt welt, int posX, int posY) {

        super(welt,posX, posY, 30, 30);
    }


    /** Zeichnet das Raumschiff */
    public void zeichne(PApplet app){
        //app.pushStyle();
        //app.fill(230, 15, 15);
        //app.triangle(posX, posY, posX + breiteDreieck, posY + breiteDreieck, posX - breiteDreieck, posY + breiteDreieck);
        if (raumschiffImage == null) {
            raumschiffImage = app.loadImage("ressources/Spaceship.png");
        }
        app.image(raumschiffImage,posX, posY, breite, hoehe);
        //app.popStyle();
    }

 /** Bewegt das Raumschiff nach links
  * Stoppt das Raumschiff am Leinwandrand */
    public void bewegeNachRechts() {

        if (posX + this.breite >= 600) {
            posX +=0;   //bewegt sich nicht weiter
        } else {
            posX += 2;
        }
    }

    /** Bewegt das Raumschiff nach links
     * Stoppt das Raumschiff am Leinwandrand */
    public void bewegeNachLinks() {

        if (posX <= 0) {
            posX +=0;   //bewegt sich nicht weiter
        } else {
            posX -= 2;
        }
    }
}
