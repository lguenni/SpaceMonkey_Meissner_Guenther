import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Spielwelt implements ISpielWelt {

    public static final int SPIELZEIT_MAX = 1*60*1000; //eine Minute
    private final long timestamp_start;

    private int breite;
    private int hoehe;

    private List<Monkey> monkeys;
    private List<Schuss> schuesse;
    private List<Spielobjekt> zuLoeschen = new ArrayList<>();
    Apollo404 raumschiff;
    Meteorit meteorit;


    public Spielwelt() {
        monkeys = new ArrayList<>();
        schuesse = new ArrayList<>();
        timestamp_start = System.currentTimeMillis();
    }

    /**
     * Berechnet die verbleibende Spielzeit mit timestamp und SPIELZEIT_MAX.
     * @return verbleibende Spielzeit als int.
     */
    public int getVerbleibendeZeit(){
        return SPIELZEIT_MAX - (int) (System.currentTimeMillis() - timestamp_start);
    }

    /**
     * Fügt der Liste monkeys einen Affe vom Typ Monkey hinzu.
     * @param monkey ist der Affe der hinzugefügt.
     */
    public void addMonkey(Monkey monkey) {
        this.monkeys.add(monkey);
    }

    /**
     * Fügt der Liste schuesse einen Schuss vom Typ Schuss hinzu.
     * @param schuss ist der Schuss der hinzugefügt wird.
     */
    public void addSchuss(Schuss schuss) {
        this.schuesse.add(schuss);
    }


    /**
     * Ruft die bewege Methode aller Affen und Schüsse auf.
     */
    public void bewege() {
        bewegeMonkeys();
        bewegeSchuesse();
        meteorit.bewege();
        pruefeKollisionen();
    }

    /**
     * Ruft die bewege Methode aller Schüsse in der Liste schüsse auf.
     */
    private void bewegeSchuesse() {
        for (Schuss schuss : schuesse) {
            schuss.bewege();
        }
    }

    /**
     * Ruft die bewege Methode aller Affen in der Liste affe auf.
     */
    private void bewegeMonkeys() {
        for (Monkey monkey : monkeys) {
            monkey.bewege();
        }
    }

    /**
     * Ruft alle prüfeKollission Methoden auf.
     */
    private void pruefeKollisionen() {
        pruefeKollisionenMeteoritSchuss();
        pruefeKollisionenMonkeySchuss();
    }

    /**
     * Prüft Kollisionen zwischen allen Monkey und Schüssen auf dem Spielfeld.
     * Falls eine Kollision auftritt wird die onKollision Methode von schuss und monkey aufgerufen.
     */
    public void pruefeKollisionenMonkeySchuss(){
        for (Monkey monkey : monkeys) {
            for (Schuss schuss : schuesse) {
                if (monkey.hasKollisionMit(schuss)) {
                    schuss.onKollisionSchuss();
                    monkey.onKollisionMonkey();
                }
            }
        }
    }

    /**
     * Prüft Kollisionen zwischen dem Meteorit und allen Schüssen auf dem Spielfeld.
     * Falls eine Kollision auftritt wird die onKollision Methode von schuss aufgerufen.
     */
    public void pruefeKollisionenMeteoritSchuss(){
        for (Schuss schuss : schuesse){
            if(meteorit.hasKollisionMit(schuss)){
                schuss.onKollisionSchuss();
            }
        }
    }

    /**
     * Zeichnet alle Elemente auf dem Spielfeld.
     */
    public void zeicheAlles(PApplet app) {
        for (Monkey monkey : monkeys) {
            monkey.zeichne(app);
        }
        for (Schuss schuss : schuesse) {
            schuss.zeichne(app);
        }
        raumschiff.zeichne(app);
        meteorit.zeichne(app);
    }

    /**
     * Ruft die bewegeNachRechts Methode des Raumschiffs auf.
     */
    public void bewegeRaumschiffRechts() {
        raumschiff.bewegeNachRechts();
    }

    /**
     * Ruft die bewegeNachLinks Methode des Raumschiffs auf.
     */
    public void bewegeRaumschiffLinks() {
        raumschiff.bewegeNachLinks();
    }

    /**
     * erzeugt einen Schuss an der aktuellen Position des Raumschiffs.
     * wird dabei mit Positionsausgleich verrechnet.
     * neuer Schuss kann nur erstellt werden wenn sich letzer Schuss über HOEHESCHUSSABSTAND befindet.
     */
    public void erzeugeSchuss() {
        int positionsausgleich = (raumschiff.breite / 2) - (Schuss.BREITESCHUSS / 2);

        if (schuesse.size() == 0) {
            addSchuss(new Schuss(this, raumschiff.getPosX() + positionsausgleich, raumschiff.getPosY()));
        } else {
            if (schuesse.get(schuesse.size() - 1).getPosY() < Schuss.HOEHESCHUSSABSTAND) {
                addSchuss(new Schuss(this, raumschiff.getPosX() + positionsausgleich, raumschiff.getPosY()));
            }
        }
    }

    /**
     * Fügt den zu löschenden Schuss der Liste zuLoeschen hinzu.
     * @param schuss Schuss der gelöscht werden soll.
     */
    @Override
    public void removeSchuss(Schuss schuss) {
        zuLoeschen.add(schuss);
    }

    /**
     * Fügt den zu löschenden Monkey der Liste zuLoeschen hinzu.
     * @param monkey Monkey der gelöscht werden soll.
     */
    @Override
    public void removeMonkey(Monkey monkey) {
        zuLoeschen.add(monkey);
    }


    /**
     * Löscht die Elemente die in der Liste "zulöschen" definiert sind aus den Listen "monkeys" und "schüsse".
     */
    public void aufraeumen() {
        monkeys.removeAll(zuLoeschen);
        schuesse.removeAll(zuLoeschen);
    }

    /**
     * Prüft die Anzahl der aktiven Monkeys auf dem Spielfeld.
     * @return Anzahl der Monkeys als int-Wert.
     */
    public int getAnzahlMonkeys(){
        return  monkeys.size();
    }

    /**
     * Prüft die Anzahl der aktiven Schüsse auf dem Spielfeld.
     * @return Anzahl der Schüsse als int-Wert.
     */
    public int getAnzahlSchuesse(){
        return schuesse.size();
    }

    /**
     * Prüft die Anzahl der zu löschenden Objekte auf dem Spielfeld.
     * @return Anzahl der zu löschenen Objekten als int-Wert.
     */
    public int getAnzahlZuLoeschen(){
        return zuLoeschen.size();
    }
}
