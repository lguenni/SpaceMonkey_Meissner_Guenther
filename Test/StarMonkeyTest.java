import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StarMonkeyTest {
    Spielwelt testwelt = new Spielwelt();


    @Test
    public void testBewege(){
        StarMonkey testStarMonkey = new StarMonkey(testwelt,300,300);
        testStarMonkey.bewege();
        Assert.assertEquals(301, testStarMonkey.posX);
    }

    @Test
    public void testBewegeMitVersetzen(){
        StarMonkey testStarMonkey = new StarMonkey(testwelt,300,300);
        testStarMonkey.setPosX(650);
        testStarMonkey.bewege();
        Assert.assertEquals(0, testStarMonkey.posX);
    }

    @Test
    public void testOnKollisionStarMonkey() {
        StarMonkey testStarMonkey = new StarMonkey(testwelt,300,300);
        testwelt.addMonkey(testStarMonkey);
        testStarMonkey.onKollisionMonkey();
        Assert.assertEquals(1,testwelt.getAnzahlZuLoeschen());

    }

}