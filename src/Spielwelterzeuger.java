public class Spielwelterzeuger {

    private Spielwelt spielwelt;
    private Spielzustand zustand;

    public Spielwelterzeuger(Spielwelt spielwelt) {
        this.spielwelt = spielwelt;
    }

    /**
     * Erzeugt das Spielfeld neu und startet das Spiel
     */
    public void initSpielwelt(){

    }

    /**
     * Prüft ob sich der aktuelle Spielzustand verändert hat
     */
    public void pruefeSpielzustand(){

    }

    public Spielzustand getZustand() {
        return zustand;
    }

    public void setZustand(Spielzustand zustand) {
        this.zustand = zustand;
    }
}
