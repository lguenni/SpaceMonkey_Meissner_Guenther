import processing.core.PApplet;

public class Apollo404 extends Spielobjekt {


    private int breiteDreick = 16;

    public Apollo404(int posX, int posY) {

        super(posX, posY, 20, 20);
    }


    /** Zeichnet das Raumschiff */
    public void zeichne(PApplet app){
        app.pushStyle();
        app.fill(230, 15, 15);
        app.triangle(posX, posY, posX +breiteDreick, posY + breiteDreick, posX - breiteDreick, posY + breiteDreick);
        app.popStyle();
    }

    public void bewegeNachRechts() {

        if (posX + breiteDreick >= 600) {
            posX +=0;   //bewegt sich nicht weiter
        } else {
            posX += 2;
        }
    }

    public void bewegeNachLinks() {

        if (posX - breiteDreick <= 0) {
            posX +=0;   //bewegt sich nicht weiter
        } else {
            posX -= 2;
        }
    }
}
