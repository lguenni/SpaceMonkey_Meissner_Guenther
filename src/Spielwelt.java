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

    public void bewegeMonster(){
        for (Monkey monkey: monkeys) {
            monkey.bewege();
        }
    }

    public void bewegeFigur(){
        figur.bewege();
    }

    public void loescheMonster(){};

    public void zeicheAlles(){};

    public void zeicheSpielzustand(){};

    public void pruefeTreffer(){};


}
