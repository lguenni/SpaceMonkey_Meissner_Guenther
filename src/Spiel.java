import processing.core.PApplet;
import processing.event.KeyEvent;

public class Spiel extends PApplet {


    Spielwelt welt;
    Spielwelterzeuger erzeuger;
    private Spielzustand zustand;

    private String ausgabeText;
    private int textXpos;
    private int textYpos;
    private int textSize;


    boolean linksGedrueckt = false;
    boolean rechtsGedrueckt = false;
    boolean leertasteGedruckt= false;


    public Spiel() {
        welt = new Spielwelt();
        erzeuger = new Spielwelterzeuger(welt);
        erzeuger.initSpielwelt();
    }

    @Override
    public void settings() {
        width = 600;
        height = 700;
    }

    @Override
    public void draw() {
        welt.zeichneHintergrund(this);
        verarbeiteEingabe();
        zeichneSpielzustand();
        welt.bewege();
        welt.zeichneAlles(this);
        welt.aufraeumen();
    }


    /** Bewegt Raumschiff nach rechts, wenn rechts gedrückt wird.
     * Bewegt Raumschiff nach links, wenn links gedrückt wird.
     * Bewegt Raumschiff und schießt, falls zwei Tasten betätigt werden.*/
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

    /**
     * Variablen werden auf "true" gesetzt, wenn zugehörige Taste gedrückt wird.
     */
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

    /**
     * Variablen werden auf "false" gesetzt, wenn die zugehörige Tasten los gelassen werden.
     */
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
     * @return aktueller Spielzustand.
     */
    public Spielzustand getSpielzustand() {
        return zustand;
    }

    /**
     * Setzt den aktuellen Spielzustand auf Läuft wenn mehr als 0 Affen vorhanden sind.
     * Setzt den aktuellen Spielzustand auf veloren wenn mehr als 3min vergangen sind.
     * Setzt den aktuellen Spielzustand auf gewonnen wenn keine Affen mehr vorhanden sind.
     */
    public void pruefeSpielzustand() {
        if (welt.getAnzahlMonkeys() == 0) {
            this.zustand = Spielzustand.SPIEL_GEWONNEN;
        }
        else if (welt.getVerbleibendeZeit() <= 0){
            this.zustand = Spielzustand.SPIEL_VERLOREN;
        }
        else {
            this.zustand = Spielzustand.SPIEL_LAEUFT;
        }
    }

    /**
     * Zeichnet den aktuellen Spielzustand auf das Spielfeld.
     * Falls das Spiel gerade läuft wird die Anzahl der verbleibenden Monkyes angezeigt.
     * Die verbleibende Spielzeit wird in Sekunden angezeigt.
     */
    public void zeichneSpielzustand(){
        pruefeSpielzustand();
        if (getSpielzustand() == Spielzustand.SPIEL_LAEUFT) {
            ausgabeText = "Es sind noch " + str(welt.getAnzahlMonkeys()) + " Monkeys zu besiegen";
            textXpos = 20;
            textYpos = 20;
            textSize = 15;
            this.pushStyle();
            this.fill(200, 200, 200);
            this.textSize(textSize);
            this.text("Verbleibende Zeit: " + str(welt.getVerbleibendeZeit()/1000) +"s", 400, 20);
            this.popStyle();

        } else if (getSpielzustand() == Spielzustand.SPIEL_GEWONNEN) {
            ausgabeText = "JUHUUU DAS WELTALL IST WIEDER SICHER!!!";
            textXpos = 30;
            textYpos = 300;
            textSize = 25;
        }else if (getSpielzustand() == Spielzustand.SPIEL_VERLOREN) {
            ausgabeText = "Oh nein, die Monkeys haben die Macht übernommen!";
            textXpos = 50;
            textYpos = 350;
            textSize = 20;
        }
        this.pushStyle();
        this.fill(200, 200, 200);
        this.textSize(textSize);
        this.text(ausgabeText,textXpos , textYpos);
        this.popStyle();
    }
}
