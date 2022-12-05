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

    public Spielobjekt(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getHoehe() {
        return hoehe;
    }

    public int getBreite() {
        return breite;
    }
}

