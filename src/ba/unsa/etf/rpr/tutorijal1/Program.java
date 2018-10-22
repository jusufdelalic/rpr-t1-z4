package ba.unsa.etf.rpr.tutorijal1;

import java.util.Scanner;

public class Program {



    public static void meni() {// za kasnije...
        System.out.println("Dobrodosli na mini-Zamger ETF Sarajevo.\n" +
                           "Molimo Vas da odaberite jednu od ponudjenih opcija:\n" +
                           "1. Kreiranje novog predmeta\n" +
                           "2. Kreiranje novog studenta\n" +
                           "3. Upis studenta na predmet\n" +
                           "4. Ispis studenta sa predmeta\n" +
                           "5. Brisanje studenta\n" +
                           "6. Brisanje predmeta\n" +
                           "7. Ispis spiska studenata na predmetu\n" +
                           "8. Kraj");

    }

    public static void main(String[] args) {


        Predmet RPR = new Predmet("RPR", 1, 100);


        Student EustahijeBrzic = new Student("Eustahije", "Brzic", 12345);
        Student PeroDjetlic = new Student ("Pero", "Djetlic", 23232);

        RPR.upisiStudenta(EustahijeBrzic);
        RPR.upisiStudenta(PeroDjetlic);

        RPR.ispisiSpisakStudenata();

        RPR.ispisiStudenta(PeroDjetlic);

        RPR.ispisiSpisakStudenata();

        System.out.println(PeroDjetlic);

        PeroDjetlic = null;
        EustahijeBrzic = null;

        RPR = null;


    }
}
