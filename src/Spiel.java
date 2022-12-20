import processing.core.PApplet;
import processing.event.KeyEvent;

import java.awt.image.renderable.RenderableImage;

public class Spiel extends PApplet {
    Spielwelt welt;
    Spielwelterzeuger erzeuger;
    private Spielzustand zustand;

    boolean linksGedrueckt = false;
    boolean rechtsGedrueckt = false;
    boolean leertasteGedruckt= false;


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

    /** ÜBERABREITENBei Tasten Betätigung wird die jeweilige "bewege"-Funktion aufgerufen*/
    private void verarbeiteEingabe() {
        if (linksGedrueckt && !rechtsGedrueckt){
            welt.bewegeRaumschiffLinks();
        } else  if (!linksGedrueckt && rechtsGedrueckt){
            welt.bewegeRaumschiffRechts();
        }
        if (leertasteGedruckt) {
            welt.erzeugeSchuss();
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
        super.keyPressed();

        if (event.getKeyCode() == LEFT) {
            linksGedrueckt = true;
        } else if (event.getKeyCode() == RIGHT) {
            rechtsGedrueckt = true;
        } else if (event.getKey() == ' ') {
            leertasteGedruckt = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        super.keyReleased();

        if (event.getKeyCode() == LEFT) {
            linksGedrueckt = false;
        } else if (event.getKeyCode() == RIGHT) {
            rechtsGedrueckt = false;
        } else if (event.getKey() == ' ') {
            leertasteGedruckt = false;
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
