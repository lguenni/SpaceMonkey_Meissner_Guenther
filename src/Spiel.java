import processing.core.PApplet;

public class Spiel extends PApplet {
    Spielwelt welt;
    Spielwelterzeuger erzeuger;

    public Spiel() {
        welt = new Spielwelt();
        erzeuger = new Spielwelterzeuger(welt);
        erzeuger.initSpielwelt();
    }

    @Override
    public void settings() {
        width = 600;
        height = 600;
    }

    @Override
    public void draw() {
        verarbeiteEingabe();
        welt.bewege();
        welt.zeicheAlles(this);
    }

    private void verarbeiteEingabe() {
        if (keyPressed) {
            if (key == 'd' || keyCode == UP) {
                welt.bewegeRaumschiffRechts();
            }

            if (key == 'a' || keyCode == DOWN) {
                welt.bewegeRaumschiffLinks();
            }
        }
    }

}
