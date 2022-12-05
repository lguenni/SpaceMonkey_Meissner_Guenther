import java.util.ArrayList;
import java.util.List;

public class Spielwelt {

    private int breite;
    private int hoehe;
    private List<Monkey> monkeys;
    private Apollo404 figur;

    public Spielwelt(int breite, int hoehe) {
        this.breite = breite;
        this.hoehe = hoehe;

        monkeys = new ArrayList<>();
    }

    /**
     * Ruft die bewege Methode aller Affen in der Liste auf
     */
    public void bewegeMonster(){
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
    public void zeicheAlles(){}

    /**
     * Zeichnet den aktuellen Spielzustand
     */
    public void zeicheSpielzustand(){}

    /**
     * Prüft ob der aktuelle Schuss ein Treffer ist
     */
    public void pruefeTreffer(){}


}
