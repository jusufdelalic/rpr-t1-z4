package ba.unsa.etf.rpr.tutorijal1;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Program {


    public static void meni() {
        System.out.println("Molimo Vas da odaberite jednu od ponudjenih opcija:\n" +
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

        Student[] nizStudenata = new Student[20];
        Predmet[] nizPredmeta = new Predmet[10];

        int brojPredmeta = 0;
        int brojStudenata = 0;

        System.out.println("Dobrodosli na mini-Zamger ETF Sarajevo.");

        while (true) {

            meni();

            Scanner ulazniTok = new Scanner(System.in);

            int izbor = ulazniTok.nextInt();
            ulazniTok.nextLine();

            switch (izbor) {

                case 1:
                    System.out.print("Unesite naziv predmeta: ");
                    String nazivPredmeta = ulazniTok.nextLine();
                    System.out.print("Unesite sifru predmeta: ");
                    int sifraPredmeta = ulazniTok.nextInt();
                    System.out.print("Unesite maksimalan broj studenata na predmetu: ");
                    int maxBrojStudenata = ulazniTok.nextInt();

                    boolean vecPostojiPredmet = false;

                    for (Predmet p : nizPredmeta) {
                        if (p != null && p.getSifraPredmeta() == sifraPredmeta) {
                            vecPostojiPredmet = true;
                            break;
                        }
                    }
                    if (!vecPostojiPredmet) {
                        nizPredmeta[brojPredmeta] = new Predmet(nazivPredmeta, sifraPredmeta, maxBrojStudenata);
                        brojPredmeta++;
                    } else System.out.println("Predmet vec postoji");
                    break;


                case 2:


                    System.out.print("Unesite ime studenta: ");
                    String imeStudenta = ulazniTok.nextLine();
                    System.out.print("Unesite prezime studenta: ");
                    String prezimeStudenta = ulazniTok.nextLine();
                    System.out.print("Unesite broj indeksa studenta: ");
                    int brojIndeksa = ulazniTok.nextInt();
                    boolean vecPostojiStudent = false;

                    for (Student s : nizStudenata) {
                        if (s != null && s.getBrojIndeksa() == brojIndeksa) {
                            vecPostojiStudent = true;
                            break;
                        }

                    }

                    if (!vecPostojiStudent) {
                        nizStudenata[brojStudenata] = new Student(imeStudenta, prezimeStudenta, brojIndeksa);
                        brojStudenata++;
                    } else System.out.println("Student vec postoji");

                    break;

                case 3:

                    Student student = null;
                    Predmet predmet = null;

                    System.out.print("Unesite broj indeksa studenta: ");
                    brojIndeksa = ulazniTok.nextInt();
                    System.out.print("Unesite sifru predmeta: ");
                    sifraPredmeta = ulazniTok.nextInt();

                    boolean postojiStudent = false;
                    boolean postojiPredmet = false;

                    for (Student s : nizStudenata) {
                        if (s != null && s.getBrojIndeksa() == brojIndeksa) {
                            student = s;
                            postojiStudent = true;
                            break;
                        }
                    }

                    for (Predmet p : nizPredmeta) {
                        if (p != null && p.getSifraPredmeta() == sifraPredmeta) {
                            predmet = p;
                            postojiPredmet = true;
                            break;
                        }
                    }

                    if (!(postojiStudent && postojiPredmet))
                        System.out.println("Ne postoji student ili predmet.");


                    else {
                        if (predmet.pohadja(student) != -1)
                            System.out.println("Student je vec upisan na taj predmet");

                        else
                            predmet.upisiStudenta(student);
                    }

                    break;


                case 4:

                        predmet = null;
                        student = null;

                    System.out.print("Unesite broj indeksa studenta: ");
                    brojIndeksa = ulazniTok.nextInt();
                    System.out.print("Unesite sifru predmeta: ");
                    sifraPredmeta = ulazniTok.nextInt();

                    postojiStudent = false;
                    postojiPredmet = false;

                    for (Student s : nizStudenata) {
                        if (s != null && s.getBrojIndeksa() == brojIndeksa) {
                            student = s;
                            postojiStudent = true;
                            break;
                        }
                    }

                    for (Predmet p : nizPredmeta) {
                        if (p != null && p.getSifraPredmeta() == sifraPredmeta) {
                            predmet = p;
                            postojiPredmet = true;
                            break;
                        }
                    }

                    if (!(postojiStudent && postojiPredmet))
                        System.out.println("Ne postoji student ili predmet.");


                    else {

                        if (predmet.pohadja(student) == -1)
                            System.out.println("Student nije upisan na predmet");

                        else predmet.ispisiStudenta(student);
                    }

                    break;

                case 5:

                    System.out.print("Unesite broj indeksa studenta: ");
                    brojIndeksa = ulazniTok.nextInt();

                    postojiStudent = false;

                    int k = 0;

                    for (int i = 0; i < brojStudenata; i++) {
                        if (nizStudenata[i].getBrojIndeksa() == brojIndeksa) {
                            postojiStudent = true;
                            k = i;
                            break;
                        }

                    }

                    if (!postojiStudent) System.out.println("Student ne postoji");
                    else {
                        for (int i = k; i < brojStudenata - 1; i++)
                            nizStudenata[i] = nizStudenata[i + 1];

                        brojStudenata--;
                    }

                    break;

                case 6:

                    System.out.print("Unesite sifru predmeta: ");
                    sifraPredmeta = ulazniTok.nextInt();

                    postojiPredmet = false;

                    k = 0;

                    for (int i = 0; i < brojPredmeta; i++) {
                        if (nizPredmeta[i].getSifraPredmeta() == sifraPredmeta) {
                            postojiPredmet = true;
                            k = i;
                            break;
                        }

                    }

                    if (!postojiPredmet) System.out.println("Predmet ne postoji");
                    else {
                        for (int i = k; i < brojPredmeta - 1; i++)
                            nizStudenata[i] = nizStudenata[i + 1];

                        brojPredmeta--;
                    }

                    break;

                case 7:

                    System.out.print("Unesite sifru predmeta: ");
                    sifraPredmeta = ulazniTok.nextInt();

                    postojiPredmet = false;

                    k = 0;

                    for (int i = 0; i < brojPredmeta; i++) {
                        if (nizPredmeta[i].getSifraPredmeta() == sifraPredmeta) {
                            postojiPredmet = true;
                            k = i;
                            break;
                        }

                    }

                    if (!postojiPredmet) System.out.println("Predmet ne postoji");

                    else {

                        nizPredmeta[k].ispisiSpisakStudenata();
                    }

                    break;

                case 8:

                    System.out.println("Hvala na posjeti, dodjite nam opet.");
                    break;


                default:
                    System.out.println("Niste odabrali valjanu opciju.");
            }

            if (izbor == 8) break;
        }


    }

}

