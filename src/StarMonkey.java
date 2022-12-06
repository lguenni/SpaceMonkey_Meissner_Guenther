import processing.core.PApplet;

public class StarMonkey extends Monkey{

    public StarMonkey(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void zeichne(PApplet app) {
        app.pushStyle();
        app.fill(230, 200, 15);
        app.rect(posX, posY, breite, hoehe);
        app.popStyle();
    }


}
