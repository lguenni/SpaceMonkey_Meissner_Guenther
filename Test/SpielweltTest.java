import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpielweltTest {

    Spielwelt testwelt = new Spielwelt();
    Schuss testSchuss = new Schuss(testwelt,300,300);


    @Test
    public void testGetVerbleibendeZeit() throws InterruptedException {
        int testVerbleibendeSekunden = testwelt.getVerbleibendeZeit() / 1000;
        int testMaxSekunden = testwelt.SPIELZEIT_MAX / 1000;

        Thread.sleep(2000);
        int testVerbleibendeSekundenNachWarten = testwelt.getVerbleibendeZeit() / 1000;

        Assert.assertTrue(testVerbleibendeSekunden <= testMaxSekunden);
        Assert.assertFalse(testVerbleibendeSekunden <= 57);

        Assert.assertTrue(testVerbleibendeSekundenNachWarten <= testMaxSekunden - 2);
    }

    @Test
    public void testAddMonkey() {
        testwelt.addMonkey(new MarsMonkey(testwelt,300,300) );
        testwelt.addMonkey(new MoonMonkey(testwelt,300,300) );
        testwelt.addMonkey(new StarMonkey(testwelt,300,300) );
        Assert.assertEquals(3,testwelt.getAnzahlMonkeys());

    }

    @Test
    public void testAddSchuss() {
        testwelt.addSchuss(new Schuss(testwelt,300,300));
        testwelt.addSchuss(new Schuss(testwelt,300,300));
        Assert.assertEquals(2,testwelt.getAnzahlSchuesse());
    }


    @Test
    public void testErzeugeSchuss() {
        testwelt.raumschiff = new Apollo404(testwelt, 300, 600);
        testwelt.erzeugeSchuss();
        Assert.assertEquals(1, testwelt.getAnzahlSchuesse());
    }

    @Test
    public void testErzeugeSchussHoehenkontrolle() {
        testwelt.raumschiff = new Apollo404(testwelt, 300, 600);
        testwelt.erzeugeSchuss();
        testwelt.erzeugeSchuss();
        Assert.assertEquals(1, testwelt.getAnzahlSchuesse());
    }

    @Test
    public void testRemoveSchuss() {
        testwelt.addSchuss(testSchuss);
        testwelt.removeSchuss(testSchuss);
        Assert.assertEquals(1,testwelt.getAnzahlZuLoeschen());
    }

    @Test
    public void testRemoveMonkey() {
        Monkey testMonkey = new MarsMonkey(testwelt,300,300);
        testwelt.addMonkey(testMonkey);
        testwelt.removeMonkey(testMonkey);
        Assert.assertEquals(1,testwelt.getAnzahlZuLoeschen());
    }

    @Test
    public void testAufraeumen() {
        Monkey testMonkey = new MarsMonkey(testwelt,300,300);
        testwelt.addMonkey(testMonkey);
        testwelt.addSchuss(testSchuss);
        testwelt.aufraeumen();
        Assert.assertEquals(0,testwelt.getAnzahlZuLoeschen());


    }

    @Test
    public void testGetAnzahlMonkeys() {
        Monkey testMonkey = new MarsMonkey(testwelt,300,300);
        testwelt.addMonkey(testMonkey);
        testwelt.addMonkey(testMonkey);
        Assert.assertEquals(2,testwelt.getAnzahlMonkeys());

    }

    @Test
    public void testGetAnzahlSchuesse() {
        testwelt.addSchuss(testSchuss);
        testwelt.addSchuss(testSchuss);
        testwelt.addSchuss(testSchuss);
        Assert.assertEquals(3,testwelt.getAnzahlSchuesse());
    }

    @Test
    public void testGetAnzahlZuLoeschen() {
        Monkey testMonkey = new MarsMonkey(testwelt,300,300);
        testwelt.removeMonkey(testMonkey);
        testwelt.removeSchuss(testSchuss);
        Assert.assertEquals(2,testwelt.getAnzahlZuLoeschen());
    }


    @Test
    public void testPruefeKollisionenMonkeySchuss(){
        testwelt.addMonkey(new MarsMonkey(testwelt, 200, 200));
        int testPosYKollision = 200 + MarsMonkey.HOEHE;
        testwelt.addSchuss(new Schuss(testwelt, 200, testPosYKollision));

        int testPosYkeineKollsion = 200 + MarsMonkey.HOEHE + 1;
        testwelt.addSchuss(new Schuss(testwelt, 2, testPosYkeineKollsion));

        testwelt.pruefeKollisionenMonkeySchuss();
        testwelt.aufraeumen();

        Assert.assertEquals(1, testwelt.getAnzahlSchuesse());
    }


    @Test
    public void testPruefeKollisionenMeteoritSchuss(){
        testwelt.meteorit = new Meteorit(testwelt, 200, 200);
        int testPosYKollision = 200 + testwelt.meteorit.hoehe;
        testwelt.addSchuss(new Schuss(testwelt, 200, testPosYKollision));

        int testPosYkeineKollsion = 200 + testwelt.meteorit.hoehe + 1;
        testwelt.addSchuss(new Schuss(testwelt, 2, testPosYkeineKollsion));

        testwelt.pruefeKollisionenMeteoritSchuss();
        testwelt.aufraeumen();

        Assert.assertEquals(1, testwelt.getAnzahlSchuesse());
    }

}