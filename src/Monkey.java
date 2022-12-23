import processing.core.PApplet;

public abstract class Monkey extends Spielobjekt {

    public static final int BREITE = 30;
    public static final int HOEHE = 30;

    public Monkey(ISpielWelt welt,int posX, int posY) {
        super(welt,posX, posY, HOEHE, BREITE);
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


    /** Methode verweist auf Methode "removeMonkey" aus Spielwelt und übergibt diese Klasse*/
    public void onKollisionMonkey (){
        welt.removeMonkey(this);

    }
}
