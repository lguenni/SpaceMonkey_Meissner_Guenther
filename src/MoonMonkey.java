import processing.core.PApplet;

public class MoonMonkey extends Monkey{

    public MoonMonkey(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void zeichne(PApplet app) {
        app.pushStyle();
        app.fill(200, 100, 100);
        app.rect(posX, posY, breite, hoehe);
        app.popStyle();
    }
}
