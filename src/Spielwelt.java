import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Spielwelt implements ISpielWelt {

    static final int HOEHESCHUSSABSTAND = 400;

    private int breite;
    private int hoehe;

    private List<Monkey> monkeys;
    private List<Schuss> schuesse;
    private List<Spielobjekt> zuLoeschen = new ArrayList<>();
    Apollo404 raumschiff;


    public Spielwelt() {
        monkeys = new ArrayList<>();
        schuesse = new ArrayList<>();
    }

    /**
     * Fügt der Liste monkeys einen Affe vom Typ Monkey hinzu
     * @param monkey ist der Affe der hinzugefügt
     */
    public void addMonkey(Monkey monkey) {
        this.monkeys.add(monkey);
    }

    /**
     * Fügt der Liste schuesse einen Schuss vom Typ Schuss hinzu
     *
     * @param schuss ist der Schuss der hinzugefügt wird
     */
    public void addSchuss(Schuss schuss) {
        this.schuesse.add(schuss);
    }


    /**
     * Ruft die bewege Methode aller Affen und Schüsse auf
     */
    public void bewege() {
        bewegeMonkeys();
        bewegeSchuesse();
        pruefeKollosionen();
    }

    /**
     * Ruft die bewege Methode aller Schüsse in der Liste schüsse auf
     */
    private void bewegeSchuesse() {
        for (Schuss schuss : schuesse) {
            schuss.bewege();
        }
    }

    /**
     * Ruft die bewege Methode aller Affen in der Liste affe auf
     */
    private void bewegeMonkeys() {
        for (Monkey monkey : monkeys) {
            monkey.bewege();
        }
    }

    /**
     * Prüft Kollissionen von jedem aktiven Schuss mit jedem aktiven Monkey
     */
    private void pruefeKollosionen() {
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
     * Zeichnet alle Elemente auf dem Spielfeld
     */
    public void zeicheAlles(PApplet app) {
        for (Monkey monkey : monkeys) {
            monkey.zeichne(app);
        }
        for (Schuss schuss : schuesse) {
            schuss.zeichne(app);
        }
        raumschiff.zeichne(app);
    }

    /**
     * Ruft die bewegeNachRechts Methode des Raumschiffs auf
     */
    public void bewegeRaumschiffRechts() {
        raumschiff.bewegeNachRechts();
    }

    /**
     * Ruft die bewegeNachLinks Methode des Raumschiffs auf
     */
    public void bewegeRaumschiffLinks() {
        raumschiff.bewegeNachLinks();
    }

    /**
     * erzeugt einen Schuss an der aktuellen Position des Raumschiffs;
     * neuer Schuss kann er erzeugt werden, wenn sich der alte Schuss
     * unterhalb von der Position 300 befindet
     */
    public void erzeugeSchuss() {
        int positionsausgleich = (raumschiff.breite / 2) - (Schuss.BREITESCHUSS / 2);
        if (schuesse.size() == 0) {
            addSchuss(new Schuss(this, raumschiff.getPosX() + positionsausgleich, raumschiff.getPosY()));
        } else {
            if (schuesse.get(schuesse.size() - 1).getPosY() < HOEHESCHUSSABSTAND) {
                addSchuss(new Schuss(this, raumschiff.getPosX() + positionsausgleich, raumschiff.getPosY()));
            }
        }
    }

    @Override
    public void removeSchuss(Schuss schuss) {
        zuLoeschen.add(schuss);
    }

    @Override
    public void removeMonkey(Monkey monkey) {
        zuLoeschen.add(monkey);
    }


    /**
     * Löscht die Elemente die in der Liste "zulöschen" definiert sind aus den Listen "monkeys" und "schüsse"
     */
    public void aufraeumen() {
        monkeys.removeAll(zuLoeschen);
        schuesse.removeAll(zuLoeschen);
    }

    /**
     * Prüft die Anzahl der aktiven Monkeys auf dem Spielfeld
     * @return Anzahl der Monkeys als int-Wert
     */
    public int pruefeAnzahlMonkeys(){
        return  monkeys.size();
    }
}
