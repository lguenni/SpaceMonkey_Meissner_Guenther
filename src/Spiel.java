import processing.core.PApplet;
import processing.event.KeyEvent;

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

    boolean linksGedrueckt = false;
    boolean rechtsGedrueckt = false;
    boolean leertasteGedruckt= false;


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
        welt.aufraeumen();
    }

    /** ÜBERABREITENBei Tasten Betätigung wird die jeweilige "bewege"-Funktion aufgerufen*/
    private void verarbeiteEingabe() {
        if (linksGedrueckt && !rechtsGedrueckt){
            welt.bewegeRaumschiffLinks();
        } else  if (!linksGedrueckt && rechtsGedrueckt){
            welt.bewegeRaumschiffRechts();
        }
        if (leertasteGedruckt && !(getSpielzustand() == Spielzustand.SPIEL_VERLOREN)) {
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
            this.pushStyle();
            this.fill(200, 200, 200);
            this.textSize(textSize);
            this.text("Verbleibende Zeit: " + str(verbleibendeZeit/1000) +"s", 400, 20);
            this.popStyle();

        } else if (getSpielzustand() == Spielzustand.SPIEL_GEWONNEN) {
            ausgabeText = "JUHUUU DAS WELTALL IST WIEDER SICHER";
            textXpos = 30;
            textYpos = 300;
            textSize = 25;
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
        this.popStyle();
    }
}
