import processing.core.PApplet;

public class MarsMonkey extends Monkey{

    public MarsMonkey(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void zeichne(PApplet app) {
        app.pushStyle();
        app.fill(230, 15, 15);
        app.rect(posX, posY, breite, hoehe);
        app.popStyle();
    }


}
