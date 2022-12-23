import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoonMonkeyTest {

    Spielwelt testwelt = new Spielwelt();


    @Test
    public void testBewege(){
        MoonMonkey testMoonMonkey = new MoonMonkey(testwelt,300,300);
        testMoonMonkey.bewege();
        Assert.assertEquals(299, testMoonMonkey.posX);
    }

    @Test
    public void testBewegeMitVersetzen(){
        MoonMonkey testMoonMonkey = new MoonMonkey(testwelt,300,300);
        testMoonMonkey.setPosX(-1);
        testMoonMonkey.bewege();
        Assert.assertEquals(600-testMoonMonkey.breite, testMoonMonkey.posX);
    }

    @Test
    public void onKollisionMoonMonkey() {
        MoonMonkey testMoonMonkey = new MoonMonkey(testwelt,300,300);
        testwelt.addMonkey(testMoonMonkey);
        testMoonMonkey.onKollisionMonkey();
        Assert.assertEquals(1,testwelt.getAnzahlZuLoeschen());

    }

}