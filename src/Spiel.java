import processing.core.PApplet;

import java.awt.image.renderable.RenderableImage;

public class Spiel extends PApplet {
    Spielwelt welt;
    Spielwelterzeuger erzeuger;
    private Spielzustand zustand;
    private final long timestamp_start;
    private String ausgabeText;
    private int textXpos;
    private int textYpos;
    private int textSize;
    private int spielZeit_max = 3*60*1000;
    private int verbleibendeZeit;

    public Spiel() {
        welt = new Spielwelt();
        erzeuger = new Spielwelterzeuger(welt);
        erzeuger.initSpielwelt();
        timestamp_start = System.currentTimeMillis();
    }

    @Override
    public void settings() {
        width = 600;
        height = 600;
    }

    @Override
    public void draw() {
        this.background(10, 20, 10);
        verarbeiteEingabe();
        zeichneSpielzustand();
        welt.bewege();
        welt.zeicheAlles(this);
        welt.aufräumen();
    }

    /** Bei Tasten Betätigung wird die jeweilige "bewege"-Funktion aufgerufen*/
    private void verarbeiteEingabe() {
        if (keyPressed && !(getSpielzustand() == Spielzustand.SPIEL_VERLOREN)) {
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
     * Setzt den aktuellen Spielzustand auf Läuft wenn mehr als 0 Affen vorhanden sind
     * Setzt den aktuellen Spielzustand auf veloren wenn mehr als 3min vergangen sind
     * Setzt den aktuellen Spielzustand auf gewonnen wenn keine Affen mehr vorhanden sind
     */
    public void pruefeSpielzustand() {
        if (welt.pruefeAnzahlMonkeys() == 0) {
            this.zustand = Spielzustand.SPIEL_GEWONNEN;
        }
        else if (System.currentTimeMillis() - timestamp_start > spielZeit_max){
            this.zustand = Spielzustand.SPIEL_VERLOREN;
        }
        else {
            this.zustand = Spielzustand.SPIEL_LAEUFT;
        }
    }

    /**
     * Zeichnet den aktuellen Spielzustand auf das Spielfeld
     * Falls das Spiel gerade läuft wird die Anzahl der verbleibenden Monkyes angezeigt
     * Die verbleibende Spielzeit wird in Sekunden angezeigt
     */
    public void zeichneSpielzustand(){
        pruefeSpielzustand();
        if (getSpielzustand() == Spielzustand.SPIEL_LAEUFT) {
            ausgabeText = "Es sind noch " + str(welt.pruefeAnzahlMonkeys()) + " Monkeys zu besiegen";
            textXpos = 20;
            textYpos = 20;
            textSize = 15;
            verbleibendeZeit = spielZeit_max - parseInt(System.currentTimeMillis() - timestamp_start);

        } else if (getSpielzustand() == Spielzustand.SPIEL_GEWONNEN) {
            ausgabeText = "JUHUUU DAS WELTALL IST WIEDER SICHER";
            textXpos = 20;
            textYpos = 300;
            textSize = 30;
        }else if (getSpielzustand() == Spielzustand.SPIEL_VERLOREN) {
            ausgabeText = "Oh nein, die Monkeys haben die Macht übernommen!";
            textXpos = 50;
            textYpos = 300;
            textSize = 20;
        }
        this.pushStyle();
        this.fill(200, 200, 200);
        this.textSize(textSize);
        this.text(ausgabeText,textXpos , textYpos);
        this.text("Verbleibende Zeit: " + str(verbleibendeZeit/1000) +"s", 400, 20);
        this.popStyle();
    }
}
