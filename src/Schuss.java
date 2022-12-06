public class Schuss extends Spielobjekt{

    public Schuss(int posX, int posY) {
        super(posX, posY, 10,10);
    }

    int Geschwindigkeit;

    /**
     * Bewegt den Schuss mit der Geschwindigkeit nach oben
     */
    public void bewege(){
        posY = posY + Geschwindigkeit;
    }
}
