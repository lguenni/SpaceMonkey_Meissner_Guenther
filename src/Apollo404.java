import processing.core.PApplet;

public class Apollo404 extends Spielobjekt {


    private int breiteDreieck = 16;

    public Apollo404(ISpielWelt welt, int posX, int posY) {

        super(welt,posX, posY, 20, 20);
    }


    /** Zeichnet das Raumschiff */
    public void zeichne(PApplet app){
        app.pushStyle();
        app.fill(230, 15, 15);
        app.triangle(posX, posY, posX + breiteDreieck, posY + breiteDreieck, posX - breiteDreieck, posY + breiteDreieck);
        app.popStyle();
    }

 /** Bewegt das Raumschiff nach links
  * Stoppt das Raumschiff am Leinwandrand */
    public void bewegeNachRechts() {

        if (posX + breiteDreieck >= 600) {
            posX +=0;   //bewegt sich nicht weiter
        } else {
            posX += 2;
        }
    }

    /** Bewegt das Raumschiff nach links
     * Stoppt das Raumschiff am Leinwandrand */
    public void bewegeNachLinks() {

        if (posX - breiteDreieck <= 0) {
            posX +=0;   //bewegt sich nicht weiter
        } else {
            posX -= 2;
        }
    }
}
