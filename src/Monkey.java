import processing.core.PApplet;

public abstract class Monkey extends Spielobjekt {

    public Monkey(ISpielWelt welt,int posX, int posY) {
        super(welt,posX, posY, 14, 14);
    }

    /**
     * Bewegt den Affe um eine Position nach rechts
     */
    public void bewege(){
        posX = posX + 1;

        if(this.getPosX() >= 600 - this.getBreite()){
            this.setPosX(0);
        }
    }

    /**
     * Abstrakte Methode zum Aufrufen der zeichne Methoden
     */
    public abstract void zeichne(PApplet app);

    public void onKollision (){
        welt.removeMonkey(this);

    }


}
