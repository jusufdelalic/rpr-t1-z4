package ba.unsa.etf.rpr.tutorijal1;

public class Student {

    private String ime;
    private String prezime;
    private int brojIndeksa;

    public void setIme(String ime){
        this.ime = ime;
    }

    public String getIme() {
        return ime;
    }

    public void setPrezime(String prezime){
        this.prezime = prezime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setBrojIndeksa(int brIndeksa) {
        brojIndeksa = brIndeksa;
    }

    public int getBrojIndeksa() {
        return brojIndeksa;
    }


    public Student(String ime, String prezime, int brojIndeksa) {
        this.ime = ime;
        this.prezime = prezime;
        this.brojIndeksa = brojIndeksa;
    }

    public void ispisi () {
      System.out.println(this);
    }

    @Override
    public String toString() { return prezime + " " + ime + " (" + brojIndeksa +")"; }

}
