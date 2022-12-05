public abstract class Monkey extends Spielobjekt {
    public Monkey(int posX, int posY) {
        super(posX, posY, 10, 10);
    }

    public void bewege(){
        posX = posX + 1;
    }

    public abstract void zeichne();
}
