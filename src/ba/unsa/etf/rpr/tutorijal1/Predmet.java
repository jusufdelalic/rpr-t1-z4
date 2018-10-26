package ba.unsa.etf.rpr.tutorijal1;


public class Predmet {


    private String nazivPredmeta;
    private int sifraPredmeta;
    private int maxBrojStudenata;
    private Student[] nizStudenata;
    private int brojStudenata;

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String naziv) {
        nazivPredmeta = naziv;
    }

    public int getSifraPredmeta() {
        return sifraPredmeta;
    }

    public void setSifraPredmeta(int sifra) {
        sifraPredmeta = sifra;
    }

    public int getBrojStudenata() {
        return brojStudenata;
    }

    public void setBrojStudenata(int broj) {
        brojStudenata = broj;
    }

    public int getMaxBrojStudenata() { return maxBrojStudenata; }




    public int pohadja(Student s) { // vracamo poziciju u nizu ako student slusa predmet, u suprotnom vracamo -1
        for(int i=0;i<brojStudenata;i++)
            if (nizStudenata[i] == s)
                return i; //poredimo reference

        return -1;
    }

    public Predmet(String nazivPredmeta, int IDPredmeta, int maxBrojStudenata) {
        this.nazivPredmeta = nazivPredmeta;
        sifraPredmeta = IDPredmeta;
        this.maxBrojStudenata = maxBrojStudenata;
        nizStudenata = new Student[maxBrojStudenata];
        brojStudenata = 0;
    }

    public boolean upisiStudenta(Student s) {   // upis studenta na predmet

        int pozicija = pohadja(s);
        if(brojStudenata >= maxBrojStudenata || pozicija != -1) return false; // dodavanje u puni red ili student je vec upisan
        nizStudenata[brojStudenata] = s;
        brojStudenata++;
        return true;
    }

    public boolean  ispisiStudenta(Student s)  { // ispis studenta sa predmeta

        int pozicija = pohadja(s);

        if(pozicija!=-1) { // da li student s pohadja predmet

            for(int i=pozicija;i<brojStudenata-1;i++)
                nizStudenata[i]=nizStudenata[i+1];

            brojStudenata--;

            return true;
        }

        else return false;

    }

    public void ispisiSpisakStudenata() {
        for(int i=0;i<brojStudenata;i++)
            System.out.println(i + 1 + ". " + nizStudenata[i]);
    }


}
