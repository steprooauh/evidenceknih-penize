public class Pracovnici {
    String popis;
    double mzda;
    int pocet;

    public Pracovnici(String popis, double mzda, int pocet){
        this.popis = popis;
        this.mzda = mzda;
        this.pocet = pocet;
    }

    public double getMzda() {
        return mzda;
    }

    public int getPocet() {
        return pocet;
    }

    public String getPopis() {
        return popis;
    }
}
