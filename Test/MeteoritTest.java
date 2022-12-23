import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MeteoritTest {
    Spielwelt testwelt = new Spielwelt();

    @Test
    public void testRandomGeschwindigkeitMeteorit() {
        Meteorit testMeteorit = new Meteorit(testwelt, 300, 300);
        int hoechsteGeschwindigkeit=0;
        int niedrigsteGeschwindigkeit=10;

        for (int i = 0; i <10000 ; i++) {
            testMeteorit.geschwindigkeit = testMeteorit.randomGeschwindigkeitMeteorit();

            if (testMeteorit.geschwindigkeit>hoechsteGeschwindigkeit){
                hoechsteGeschwindigkeit= testMeteorit.geschwindigkeit;

            }else if(testMeteorit.geschwindigkeit<niedrigsteGeschwindigkeit){
                niedrigsteGeschwindigkeit= testMeteorit.geschwindigkeit;
            }
        }

        Assert.assertEquals(1,niedrigsteGeschwindigkeit);
        Assert.assertEquals(5,hoechsteGeschwindigkeit);


    }

    @Test
    public void testRandomHoeheMeteorit() {
        Meteorit testMeteorit = new Meteorit(testwelt, 300, 300);
        int hoechsteHoehe=0;
        int niedrigsteHoehe=1000;

        for (int i = 0; i <10000 ; i++) {
            testMeteorit.hoehe = testMeteorit.randomHoeheMeteorit();

            if (testMeteorit.hoehe>hoechsteHoehe){
                hoechsteHoehe= testMeteorit.hoehe;

            }else if(testMeteorit.hoehe<niedrigsteHoehe){
                niedrigsteHoehe= testMeteorit.hoehe;
            }
        }

        Assert.assertEquals(350,niedrigsteHoehe);
        Assert.assertEquals(550,hoechsteHoehe);
    }

    @Test
    public void testBewege() {
        Meteorit testMeteorit = new Meteorit(testwelt, 300,300);
        testMeteorit.geschwindigkeit= 3;
        testMeteorit.bewege();
        Assert.assertEquals(303,testMeteorit.posX);
    }
}