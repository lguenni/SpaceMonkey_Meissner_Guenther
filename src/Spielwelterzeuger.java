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
        spielwelt.addMonkey(new MarsMonkey(50, 50));
        spielwelt.addMonkey(new MarsMonkey(100, 50));
        spielwelt.addMonkey(new MoonMonkey(50, 150));
        spielwelt.addMonkey(new MoonMonkey(100, 150));
        spielwelt.addMonkey(new StarMonkey(50,250));
        spielwelt.addMonkey(new StarMonkey(100, 250));

        spielwelt.figur = new Apollo404(20, 20);
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
