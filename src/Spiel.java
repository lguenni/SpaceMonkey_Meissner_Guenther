import processing.core.PApplet;

import java.awt.image.renderable.RenderableImage;

public class Spiel extends PApplet {
    Spielwelt welt;
    Spielwelterzeuger erzeuger;
    private Spielzustand zustand;


    public Spiel() {
        welt = new Spielwelt();
        erzeuger = new Spielwelterzeuger(welt);
        erzeuger.initSpielwelt();
        setSpielZustand(Spielzustand.SPIEL_LAEUFT);
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
        welt.aufräumen();
    }

    /** Bei Tasten Betätigung wird die jeweilige "bewege"-Funktion aufgerufen*/
    private void verarbeiteEingabe() {
        if (keyPressed) {
            if (key == 'd' || keyCode == RIGHT) {
                welt.bewegeRaumschiffRechts();
            }

            if (key == 'a' || keyCode == LEFT) {
                welt.bewegeRaumschiffLinks();
            }

            if (key == ' ' || keyCode == UP || key == 'w'){
                welt.erzeugeSchuss();
            }
        }
    }

    /**
     * Gibt den Spielzustand in dem sich das aktuelle Spiel befindet zurück
     * @return aktueller Spielzustand
     */
    public Spielzustand getSpielzustand() {
        return zustand;
    }

    /**
     * Setzt den aktuelle Spielzustand
     * @param zustand zu setzender Zustand
     */
    public void setSpielZustand(Spielzustand zustand) {
        this.zustand = zustand;
    }

    /**
     * Prüft ob sich der aktuelle Spielzustand verändert hat
     */
    public void pruefeSpielzustand(){}

}
