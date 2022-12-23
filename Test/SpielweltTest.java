import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpielweltTest {

    Spielwelt testwelt = new Spielwelt();
    Schuss testSchuss = new Schuss(testwelt,300,300);


    @Test
    public void testGetVerbleibendeZeit() throws InterruptedException {
        long  testTimeStamp = System.currentTimeMillis();
       int verbeleibendeZeit =  testwelt.SPIELZEIT_MAX - (int)(System.currentTimeMillis()-testTimeStamp);
       Thread.sleep(10);
       Assert.assertEquals(59990,testwelt.getVerbleibendeZeit());
       //Irgendwie zählt der ned gleichmäßig runter? Hast du da ne Idee?
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
        //Konnte mich spontan nicht reindenken...
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
        testwelt.addMonkey(testMonkey);
        testwelt.removeMonkey(testMonkey);
        testwelt.addSchuss(testSchuss);
        testwelt.removeSchuss(testSchuss);
        Assert.assertEquals(2,testwelt.getAnzahlZuLoeschen());

    }

    //Hatte leider keine Zeit mehr :/
    @Test
    private void testPruefeKollisionen() {

    }

    @Test
    private void testPruefeKollisionenMonkeySchuss(){

    }

    @Test
    private void testPruefeKollisionenMeteoritSchuss(){

    }

}