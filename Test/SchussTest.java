import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SchussTest {

    Spielwelt testwelt = new Spielwelt();

    @Test
    public void testBewege() {
        Schuss testSchuss =  new Schuss(testwelt,300,300);
        testSchuss.bewege();
        Assert.assertEquals(300-testSchuss.GESCHWINDIGKEIT,testSchuss.posY);
    }

    @Test
    public void testOnKollisionSchuss() {
        Schuss testSchuss =  new Schuss(testwelt,300,300);
        testwelt.addSchuss(testSchuss);
        testSchuss.onKollisionSchuss();
        Assert.assertEquals(1,testwelt.getAnzahlZuLoeschen());

    }
}