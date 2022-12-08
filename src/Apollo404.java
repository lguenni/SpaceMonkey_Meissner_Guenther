import processing.core.PApplet;

public class Apollo404 extends Spielobjekt {

    private int munition;

    public Apollo404(int posX, int posY) {

        super(posX, posY, 20, 20);
    }

    /**
     * Gibt Anzahl der Monition zurück
     **/
    public int getMunition() {
        return munition;
    }

    /**
     * Setzt die Anzahl Monition
     * @param munition Anzahl der Monition
     */
    public void setMunition(int munition) {
        this.munition = munition;
    }

    /**
     * Bewegt Raumschiff mit Pfeiltaste
     *  */
    public void bewege(){
        //Mit Pfeiltasten eingabe
    }

    /** Zeichnet das Raumschiff */
    public void zeichne(PApplet app){
        app.pushStyle();
        app.fill(230, 15, 15);
        app.triangle(posX, posY, posX - 16, posY + 16, posX + 16, posY + 16);
        app.popStyle();
    }
}
