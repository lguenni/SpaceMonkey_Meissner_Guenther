import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Spielwelt implements ISpielWelt {

    private int breite;
    private int hoehe;
    private List<Monkey> monkeys;
    private List<Schuss> schuesse;
    private List<Spielobjekt> zuLöschen = new ArrayList<>();
    Apollo404 raumschiff;

    public Spielwelt() {
        monkeys = new ArrayList<>();
        schuesse = new ArrayList<>();
    }

    /**
     * Fügt der Liste monkeys einen Affe vom Typ Monkey hinzu
     *
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
        bewegeSchüsse();
        prüfeKollosionen();
    }

    private void bewegeSchüsse() {
        for (Schuss schuss : schuesse) {
            schuss.bewege();
        }
    }

    private void bewegeMonkeys() {
        for (Monkey monkey : monkeys) {
            monkey.bewege();
        }
    }

    private void prüfeKollosionen() {
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
        app.background(10, 20, 10);
        for (Monkey monkey : monkeys) {
            monkey.zeichne(app);
        }
        for (Schuss schuss : schuesse) {
            schuss.zeichne(app);
        }
        raumschiff.zeichne(app);
    }

    /**
     * Zeichnet den aktuellen Spielzustand
     */
    public void zeicheSpielzustand() {
    }

    /**
     * Prüft ob der aktuelle Schuss ein Treffer ist
     */
    public void pruefeTreffer() {
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
        if (schuesse.size() == 0) {
            addSchuss(new Schuss(this, raumschiff.getPosX() - 3, raumschiff.getPosY()));
        } else {
            if (schuesse.get(schuesse.size() - 1).getPosY() < 300) {
                addSchuss(new Schuss(this, raumschiff.getPosX() - 3, raumschiff.getPosY()));
            }
        }
    }

    @Override
    public void removeSchuss(Schuss schuss) {
        zuLöschen.add(schuss);
//        schuesse.remove(schuss);
    }

    @Override
    public void removeMonkey(Monkey monkey) {
        zuLöschen.add(monkey);
//        monkeys.remove(monkey);
    }

    public void aufräumen() {
        monkeys.removeAll(zuLöschen);
        schuesse.removeAll(zuLöschen);
    }
}
