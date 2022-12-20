import processing.core.PApplet;

public class Schuss extends Spielobjekt{

    static final int GESCHWINDIGKEIT = 3;

    public Schuss(ISpielWelt welt,int posX, int posY) {
        super(welt,posX, posY, 10, welt.getBreiteSchuss());
    }

    /**
     * Bewegt den Schuss mit der Geschwindigkeit nach oben
     */
    public void bewege(){
        posY = posY - GESCHWINDIGKEIT;
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
