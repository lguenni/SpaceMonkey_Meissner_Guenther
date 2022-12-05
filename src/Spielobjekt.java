public abstract class Spielobjekt {

    protected int posX;
    protected int posY;
    protected int hoehe;
    protected int breite;

    public Spielobjekt(int posX, int posY, int hoehe, int breite) {
        this.posX = posX;
        this.posY = posY;
        this.hoehe = hoehe;
        this.breite = breite;
    }

    /**
     * Setzt X-Koordinate des Objektes
     * @param posX X-Koordinate
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Setzt Y-Koordinate des Objektes
     * @param posY Y-Koordinate
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /** Gibt X-Koordinate zurück */

    public int getPosX() {
        return posX;
    }

    /** Gibt Y-Koordinate zurück */
    public int getPosY() {
        return posY;
    }

    /** Gibt Höhe des Objektes zurück*/
    public int getHoehe() {
        return hoehe;
    }

    /** Gibt Breite des Objektes zurück*/
    public int getBreite() {
        return breite;
    }
}

