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
