import processing.core.PApplet;

public class Schuss extends Spielobjekt{

    public Schuss(ISpielWelt welt,int posX, int posY) {
        super(welt,posX, posY, 10,6);
    }

    int Geschwindigkeit = 3;

    /**
     * Bewegt den Schuss mit der Geschwindigkeit nach oben
     */
    public void bewege(){
        posY = posY - Geschwindigkeit;
    }

/** Erstellt das Schussobjekt grafisch*/
    public void zeichne(PApplet app) {
        app.pushStyle();
        app.fill(255, 0, 127);
        app.rect(posX, posY, breite, hoehe);
        app.popStyle();
    }

    /** Methode verweist auf Methode "removeSchuss" aus Spielwelt und übergibt diese Klasse*/
    public void onKollisionSchuss (){
        welt.removeSchuss(this);
    }
}
