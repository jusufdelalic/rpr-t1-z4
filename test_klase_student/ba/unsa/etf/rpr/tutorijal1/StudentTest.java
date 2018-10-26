package ba.unsa.etf.rpr.tutorijal1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void setIme() {

        Student MikiMaus = new Student ("John", "Maus", 12345);
        assertEquals("John",MikiMaus.getIme());

        MikiMaus.setIme("Miki");

        assertEquals("Miki",MikiMaus.getIme());
    }

    @Test
    void getIme() {

        Student ABC = new Student("ABC","DEF",12345);
        assertEquals("ABC",ABC.getIme());
    }

    @Test
    void testKonstruktora() {

        Student student = new Student("Morris", "Mano", 12345);
        assertEquals("Mano Morris (12345)", student.toString());
    }


    @Test
    void ispisi() {

        Student noviStudent = new Student("Ime", "Prezime", 12345);
        assertEquals("Prezime Ime (12345)",noviStudent.toString());

    }




}