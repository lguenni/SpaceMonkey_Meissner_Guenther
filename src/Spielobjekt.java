import processing.core.PApplet;
import processing.core.PImage;

public abstract class Spielobjekt {

    protected int posX;
    protected int posY;
    protected int hoehe;
    protected int breite;
    ISpielWelt welt;

    public Spielobjekt(ISpielWelt welt,int posX, int posY, int hoehe, int breite) {
        this.posX = posX;
        this.posY = posY;
        this.hoehe = hoehe;
        this.breite = breite;
        this.welt = welt;
    }

    /**
     * Setzt X-Koordinate des Objektes.
     * @param posX X-Koordinate.
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Setzt Y-Koordinate des Objektes.
     * @param posY Y-Koordinate.
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /** Gibt X-Koordinate zurück. */

    public int getPosX() {
        return posX;
    }

    /** Gibt Y-Koordinate zurück. */
    public int getPosY() {
        return posY;
    }

    /** Gibt Höhe des Objektes zurück. */
    public int getHoehe() {
        return hoehe;
    }

    /** Gibt Breite des Objektes zurück. */
    public int getBreite() {
        return breite;
    }

    /**
     * Frägt die Kollisionsbedingungen ab.
     * @param that Das andere Objekt, mit welchem eine Kollision möglich ist.
     * @return true bei Kollision, false bei keiner Kollision.
     */
    public boolean hasKollisionMit(Spielobjekt that){
        boolean kollisionXrechts = this.getPosX()+this.getBreite() >= that.getPosX();
        boolean kollisionXlinks = that.getPosX()+that.getBreite()>= this.getPosX();
        boolean kollisionYoben = this.getPosY()+this.getHoehe() >= that.getPosY();
        boolean kollisionYunten = that.getPosY()+that.getHoehe() >= this.getPosY();

        boolean kollisionX = kollisionXlinks && kollisionXrechts;
        boolean kollisionY = kollisionYoben && kollisionYunten;

        return kollisionX && kollisionY;
    }

    /**
     * Lädt in einer Schleife alle Frames mit der loadImage Methode.
     * @param app Instanz von PApplet.
     * @param template String Variable mit Namen der Frames.
     * @param n Anzahl der Frames die geladen werden sollen.
     * @return PImages Array mit allen Frames.
     */
    protected PImage[] loadFrames(PApplet app, String template, int n) {
        PImage[] frames = new PImage[n];
        for (int i = 0; i < n; i++) {
            String filename = String.format(template, i + 1);
            frames[i] = app.loadImage(filename);
        }
        return frames;
    }
}

