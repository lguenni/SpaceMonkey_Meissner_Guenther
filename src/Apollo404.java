public class Apollo404 extends Spielobjekt {

    private int munition;

    public Apollo404(int posX, int posY, int hoehe, int breite) {
        super(posX, posY, hoehe, breite);
    }

    public int getMunition() {
        return munition;
    }

    public void setMunition(int munition) {
        this.munition = munition;
    }

    public void bewege(){
        //Mit Pfeiltasten eingabe
    }

    public void zeichne(){};
}
