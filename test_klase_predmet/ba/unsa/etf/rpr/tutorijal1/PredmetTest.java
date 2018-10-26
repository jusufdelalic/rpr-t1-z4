package ba.unsa.etf.rpr.tutorijal1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredmetTest {


    @Test
    void testKonstruktora() {
        Predmet p = new Predmet("Predmet",123, 456);
        assertEquals("Predmet (123), 456", p.getNazivPredmeta() + " (" + p.getSifraPredmeta() + "), " + p.getMaxBrojStudenata());
    }

    @Test
    void setNazivPredmeta() {

        Predmet nekiPredmet = new Predmet("Numericki algoritmi",42, 300);
        nekiPredmet.setNazivPredmeta("Osnove baza podataka");
        assertEquals("Osnove baza podataka", nekiPredmet.getNazivPredmeta());
    }

    @Test
    void getNazivPredmeta() {

        Predmet nekiPredmet = new Predmet("Numericki algoritmi",42, 300);
        assertEquals("Numericki algoritmi", nekiPredmet.getNazivPredmeta());
    }

    @Test
    void getBrojStudenata() {

        Predmet IM2 = new Predmet("IM2",123,400);

        assertEquals(0, IM2.getBrojStudenata());

        Student EustahijeBrzic = new Student("Eustahije", "Brzic", 12345);
        IM2.upisiStudenta(EustahijeBrzic);
        Student PeroDjetlic = new Student("Pero", "Djetlic", 45678);
        IM2.upisiStudenta(PeroDjetlic);

        assertEquals(2, IM2.getBrojStudenata());

        IM2.ispisiStudenta(EustahijeBrzic);

        assertEquals(1, IM2.getBrojStudenata());

    }

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
            Student PcelicaMaja = new Student ("Maja","Pcelica", 18123);

            assertAll( "upisivanje istog studenta dva puta na isti predmet",
                    () -> assertTrue(IM1.upisiStudenta(PcelicaMaja)),
                    () -> assertFalse(IM1.upisiStudenta(PcelicaMaja))
        );
    }

    @Test
    void ispisiStudenta() {

        Predmet RPR = new Predmet("Razvoj programskih rjesenja", 1, 100);
        Student LinusTorvalds = new Student("Linus", "Torvalds", 18000);
        RPR.upisiStudenta(LinusTorvalds);
        Student MorrisMano = new Student ("Morris", "Mano", 10000);

        assertAll("ispisivanje studenta koji se ne nalazi na predmetu",
                () -> assertTrue(RPR.ispisiStudenta(LinusTorvalds)),
                () -> assertFalse(RPR.ispisiStudenta(MorrisMano))
        );

    }




}