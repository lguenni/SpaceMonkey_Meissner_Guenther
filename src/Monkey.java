public abstract class Monkey extends Spielobjekt {
    public Monkey(int posX, int posY) {
        super(posX, posY);

        //Alle Affen sind gleich groß
        hoehe = 10;
        breite = 10;
    }

    public void bewege(){
        posX = posX + 1;
    }

    public abstract void zeichne();
}
