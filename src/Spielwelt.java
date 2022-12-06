import java.util.ArrayList;
import java.util.List;

public class Spielwelt {

    private int breite;
    private int hoehe;
    private List<Monkey> monkeys;
    private List<Schuss> schuesse;
    Apollo404 figur;

    public Spielwelt(int breite, int hoehe) {
        this.breite = breite;
        this.hoehe = hoehe;

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
     * Ruft die bewege Methode aller Affen in der Liste auf
     */
    public void bewegeAffen(){
        for (Monkey monkey: monkeys) {
            monkey.bewege();
        }
    }

    /**
     * Ruft die bewege Methode der Figur auf
     */
    public void bewegeFigur(){
        figur.bewege();
    }

    /**
     * Löscht den übergebenen Affe vom Spielfeld
     * @param monkey Zu löschender Affe
     */

    public void loescheMonster(Monkey monkey){}

    /**
     * Zeichnet alle Elemente auf dem Spielfeld
     */
    public void zeicheAlles(){
        for (Monkey monkey: monkeys) {
            monkey.zeichne();
        }
        for (Schuss schuss: schuesse) {
            schuss.zeichne();
        }
    }
    /**
     * Zeichnet den aktuellen Spielzustand
     */
    public void zeicheSpielzustand(){}

    /**
     * Prüft ob der aktuelle Schuss ein Treffer ist
     */
    public void pruefeTreffer(){}


}
