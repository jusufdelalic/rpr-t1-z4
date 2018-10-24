package ba.unsa.etf.rpr.tutorijal1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredmetTest {

    @Test
    void pohadja() {

        Predmet RPR = new Predmet("Razvoj programskih rjesenja", 1, 100);
        Student LinusTorvalds = new Student("Linus", "Torvalds", 18000);
        RPR.upisiStudenta(LinusTorvalds);
        Student DuskoDugousko = new Student("Dusko", "Dugousko", 12345);


        assertAll ("pohadjanje studenata na predmetu",
                () -> assertNotEquals(-1,RPR.pohadja(LinusTorvalds)),
                () -> assertEquals(-1,RPR.pohadja(DuskoDugousko))
        );
    }

    @Test
    void upisiStudenta() {

            Predmet IM1 = new Predmet ("Inzenjerska matematika 1", 2, 200);
        assertTrue(IM1.upisiStudenta(new Student ("Maja", "Pcelica", 17123)));
    }

    @Test
    void ispisiStudenta() {

        Predmet RPR = new Predmet("Razvoj programskih rjesenja", 1, 100);
        Student LinusTorvalds = new Student("Linus", "Torvalds", 18000);
        RPR.upisiStudenta(LinusTorvalds);

        assertTrue(RPR.ispisiStudenta(LinusTorvalds));

    }

    @Test
    void ispisiSpisakStudenata() {

        /*Predmet LD = new Predmet("Logicki Dizajn", 3, 150);
        LD.upisiStudenta(new Student("Morris", "Mano", 18001));

        assertEquals("1. Mano Morris (18001)\n", LD.ispisiSpisakStudenata().);
        */

    }
}