public class Kniha{

    private int ID;
    private String nazev;
    private String autor;
    private int rok;
    private int cena;

    public Kniha(int id, String nazev, String autor, int rok, int cena) {
        this.ID = id;
        this.nazev = nazev;
        this.autor = autor;
        this.rok = rok;
        this.cena = cena;
    }

    public int getCena() {
        return cena;
    }

    public int getID() {
        return ID;
    }

    public int getRok() {
        return rok;
    }

    public String getAutor() {
        return autor;
    }

    public String getNazev() {
        return nazev;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }
}