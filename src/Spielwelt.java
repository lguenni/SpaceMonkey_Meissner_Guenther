import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Spielwelt {

    private int breite;
    private int hoehe;
    private List<Monkey> monkeys;
    private List<Schuss> schuesse;
    Apollo404 raumschiff;

    public Spielwelt() {
        monkeys = new ArrayList<>();
        schuesse = new ArrayList<>();
    }

    /**
     * Fügt der Liste monkeys einen Affe vom Typ Monkey hinzu
     * @param monkey ist der Affe der hinzugefügt
     */
    public void addMonkey(Monkey monkey) {this.monkeys.add(monkey);}

    /**
     * Fügt der Liste schuesse einen Schuss vom Typ Schuss hinzu
     * @param schuss ist der Schuss der hinzugefügt wird
     */
    public void addSchuss(Schuss schuss) {this.schuesse.add(schuss);}


    /**
     * Ruft die bewege Methode aller Affen und Schüsse auf
     */
    public void bewege(){
        for (Monkey monkey: monkeys) {
            monkey.bewege();
        }
        for (Schuss schuss: schuesse) {
            schuss.bewege();
        }
    }

    /**
     * Zeichnet alle Elemente auf dem Spielfeld
     */
    public void zeicheAlles(PApplet app){
        app.background(10, 20, 10);
        for (Monkey monkey: monkeys) {
            monkey.zeichne(app);
        }
        for (Schuss schuss: schuesse) {
            schuss.zeichne(app);
        }
        raumschiff.zeichne(app);
    }

    /**
     * Zeichnet den aktuellen Spielzustand
     */
    public void zeicheSpielzustand(){}

    /**
     * Prüft ob der aktuelle Schuss ein Treffer ist
     */
    public void pruefeTreffer(){}

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
            addSchuss(new Schuss(raumschiff.getPosX() - 3 , raumschiff.getPosY()));
        }else{
            if (schuesse.get(schuesse.size()-1).getPosY() < 300) {
                addSchuss(new Schuss(raumschiff.getPosX() - 3, raumschiff.getPosY()));
            }
        }
    }

    /**
     * löscht einen Schuss aus der Liste schuesse
     * @param posInListe Position des zu löschenden Schusses in der Liste schuesse
     */
    public void removeSchuss(int posInListe){
        if (schuesse.size()>= posInListe) {
            schuesse.remove(posInListe);
        }
    }


    /**
     * Löscht den übergebenen Affe vom Spielfeld
     * @param posInListe Zu löschender Affe
     */
    public void removeMonkey(int posInListe){}

}
