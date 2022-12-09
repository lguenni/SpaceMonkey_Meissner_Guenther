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
        setMonkeys(8);
        spielwelt.raumschiff = new Apollo404(300, 500);
        setZustand(Spielzustand.SPIEL_LAEUFT);
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

    /**
     * Ruft die addMonkey Methoden für alle drei Monkey Methoden auf.
     * Die Affen werden automatisch in gleichmäßigem Abstand gesetzt.
     * @param AffenProZeile Anzahl der Affen die pro Typ gesetzt werden
     */
    public void setMonkeys(int AffenProZeile){
        int widthCanvas = 600;
        int abstand = (widthCanvas-14) / (AffenProZeile); //width-Affenbreite

        for (int i = 1; i < AffenProZeile + 1; i++) {
            spielwelt.addMonkey(new MarsMonkey(i * abstand, 50));
            spielwelt.addMonkey(new MoonMonkey(i * abstand, 150));
            spielwelt.addMonkey(new StarMonkey(i * abstand, 250));
        }



    }
}
