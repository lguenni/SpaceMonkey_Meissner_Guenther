import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpielwelterzeugerTest {

    Spielwelt testwelt = new Spielwelt();
    Spielwelterzeuger testerzeuger = new Spielwelterzeuger(testwelt);

    @Test
    public void initSpielwelt() {
        testerzeuger.initSpielwelt();
        Assert.assertEquals(3*8, testwelt.getAnzahlMonkeys());
        Assert.assertNotEquals(null, testwelt.raumschiff);
        Assert.assertNotEquals(null, testwelt.meteorit);
    }

    @Test
    public void createMonkeys() {
        testerzeuger.createMonkeys(10);
        Assert.assertEquals(3*10, testwelt.getAnzahlMonkeys());
    }
}