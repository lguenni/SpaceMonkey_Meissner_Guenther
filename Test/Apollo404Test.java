import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Apollo404Test {

    Spielwelt testwelt = new Spielwelt();

    @Test
    public void testBewegeNachRechts(){
        Apollo404 testRaumschiff = new Apollo404(testwelt,300,300);
        testRaumschiff.bewegeNachRechts();
        Assert.assertEquals(302,testRaumschiff.posX);
    }

    @Test
    public void testBewegeNachLinks(){
        Apollo404 testRaumschiff = new Apollo404(testwelt,300,300);
        testRaumschiff.bewegeNachLinks();
        Assert.assertEquals(298,testRaumschiff.posX);

    }
}