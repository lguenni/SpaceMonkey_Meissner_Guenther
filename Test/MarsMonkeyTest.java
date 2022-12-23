import org.junit.Assert;
import org.junit.Test;
import processing.core.PApplet;
import processing.core.PImage;

import static org.junit.Assert.*;

public class MarsMonkeyTest extends PApplet{

    Spielwelt testwelt = new Spielwelt();

    @Test
    public void testLoadFrames(){
        MarsMonkey testMarsMonkey = new MarsMonkey(testwelt,300,300);
        testMarsMonkey.frames = null;
        testMarsMonkey.loadFrames(this);
        Assert.assertNotEquals(null, testMarsMonkey.frames);

    }

    @Test
    public void testBewege(){
        MarsMonkey testMarsMonkey = new MarsMonkey(testwelt,300,300);
        testMarsMonkey.bewege();
        Assert.assertEquals(301, testMarsMonkey.posX);
    }

    @Test
    public void testBewegeMitVersetzen(){
        MarsMonkey testMarsMonkey = new MarsMonkey(testwelt,300,300);
        testMarsMonkey.setPosX(650);
        testMarsMonkey.bewege();
        Assert.assertEquals(0, testMarsMonkey.posX);
    }

    @Test
    public void onKollisionMarsMonkey() {
        MarsMonkey testMarsMonkey = new MarsMonkey(testwelt,300,300);
        testwelt.addMonkey(testMarsMonkey);
        testMarsMonkey.onKollisionMonkey();
        Assert.assertEquals(1,testwelt.getAnzahlZuLoeschen());

    }
}