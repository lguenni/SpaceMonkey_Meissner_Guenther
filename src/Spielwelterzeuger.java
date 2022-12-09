public class Spielwelterzeuger {

    private Spielwelt spielwelt;


    public Spielwelterzeuger(Spielwelt spielwelt) {
        this.spielwelt = spielwelt;
    }

    /**
     * Erzeugt das Spielfeld neu und startet das Spiel
     */
    public void initSpielwelt(){
        createMonkeys(8);
        spielwelt.raumschiff = new Apollo404(300, 500);
    }


    /**
     * Ruft die addMonkey Methoden für alle drei Monkey Methoden auf.
     * Die Affen werden automatisch in gleichmäßigem Abstand gesetzt.
     * @param affenProZeile Anzahl der Affen die pro Typ gesetzt werden
     */
    public void createMonkeys(int affenProZeile){
        int widthCanvas = 600;
        int abstand = (widthCanvas-14) / (affenProZeile); //width-Affenbreite

        for (int i = 1; i < affenProZeile + 1; i++) {
            spielwelt.addMonkey(new MarsMonkey(i * abstand, 50));
            spielwelt.addMonkey(new MoonMonkey(i * abstand, 150));
            spielwelt.addMonkey(new StarMonkey(i * abstand, 250));
        }



    }
}
