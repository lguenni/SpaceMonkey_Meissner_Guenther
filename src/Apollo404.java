public class Apollo404 extends Spielobjekt {

    private int munition;

    public Apollo404(int posX, int posY, int hoehe, int breite) {
        super(posX, posY, hoehe, breite);
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
    public void zeichne(){}
}
