public class Spielwelterzeuger {

    private Spielwelt welt;


    public Spielwelterzeuger(Spielwelt welt) {
        this.welt = welt;
    }

    /**
     * Erzeugt das Spielfeld neu und startet das Spiel.
     */
    public void initSpielwelt(){
        createMonkeys(8);
        welt.raumschiff = new Apollo404(welt,300, 650);
        welt.meteorit = new Meteorit(welt,0,550);
    }


    /**
     * Ruft die addMonkey Methoden für alle drei Monkey Methoden auf.
     * Die Affen werden automatisch in gleichmäßigem Abstand gesetzt.
     * @param affenProZeile Anzahl der Affen die pro Typ gesetzt werden.
     */
    public void createMonkeys(int affenProZeile){
        int widthCanvas = 600;
        int abstand = (widthCanvas-14) / (affenProZeile); //width-Affenbreite

        for (int i = 1; i < affenProZeile + 1; i++) {
            welt.addMonkey(new MarsMonkey(welt,i * abstand, 50));
            welt.addMonkey(new MoonMonkey(welt,i * abstand, 150));
            welt.addMonkey(new StarMonkey(welt,i * abstand, 250));
        }



    }
}
