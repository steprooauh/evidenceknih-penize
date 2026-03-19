public class Trasa {
    String nazev;
    String pohori;
    double delka;
    int prevyseni;
    String obtiznost;

    public Trasa(String nazev, String pohori, double delka, int prevyseni, String obtiznost){
        this.nazev = nazev;
        this.pohori = pohori;
        this.delka = delka;
        this.prevyseni = prevyseni;
        this.obtiznost = obtiznost;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setDelka(double delka) {
        this.delka = delka;
    }

    public void setObtiznost(String obtiznost) {
        this.obtiznost = obtiznost;
    }

    public void setPohori(String pohori) {
        this.pohori = pohori;
    }

    public void setPrevyseni(int prevyseni) {
        this.prevyseni = prevyseni;
    }

    public String getNazev() {
        return nazev;
    }

    public double getDelka() {
        return delka;
    }

    public String getObtiznost() {
        return obtiznost;
    }

    public int getPrevyseni() {
        return prevyseni;
    }

    public String getPohori() {
        return pohori;
    }
}
