import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EvidenceKnih {
    private JPanel mainpanel;
    private JTextField tfId;
    private JTextField tfNazev;
    private JTextField tfAutor;
    private JTextField tfRok;
    private JTextField tfCena;
    private JButton btnPredchozi;
    private JButton btnDalsi;
    private JButton btnPridat;

    private final ArrayList<Kniha> seznam = new ArrayList<>();
    private String[] data;

    private int index = 0;

    public EvidenceKnih() {
        tfId.setEditable(false);
        nactiZeSouboru();
        if(!seznam.isEmpty()){
            index = 0;
            zobraz();
        }

        btnPredchozi.addActionListener(e -> {
            index--;
            if(index < 0){
                index = seznam.size() - 1;
            }
            zobraz();
        });

        btnDalsi.addActionListener(e -> {
            index++;
            if(index >= seznam.size()){
                index = 0;
            }
            zobraz();
        });

        btnPridat.addActionListener(e -> {
            try {
                pridat();
            } catch (FileNotFoundException | UnsupportedEncodingException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void nactiZeSouboru(){
        try (Scanner sc = new Scanner(new File("kniha.txt"))){
            while (sc.hasNextLine()){
                String radek = sc.nextLine();
                String[] data = radek.split(";");

                if (data.length == 5){
                    int id = Integer.parseInt(data[0]);
                    String nazev = data[1];
                    String autor = data[2];
                    int rok = Integer.parseInt(data[3]);
                    int cena = Integer.parseInt(data[4]);

                    Kniha k = new Kniha(id, nazev, autor, rok, cena);
                    seznam.add(k);
                }
            }
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "není soubor");
        }
    }

    private void zobraz(){
        Kniha k = seznam.get(index);

        tfId.setText(String.valueOf(k.getID()));
        tfNazev.setText(k.getNazev());
        tfAutor.setText(k.getAutor());
        tfCena.setText(String.valueOf(k.getCena()));
        tfRok.setText(String.valueOf(k.getRok()));
    }

    private void pridat() throws FileNotFoundException, UnsupportedEncodingException {
        int id = seznam.size() +1;
        String nazev = JOptionPane.showInputDialog(null, "Vložte název knihy");
        String autor = JOptionPane.showInputDialog(null, "Vložte název autora");
        int rok = Integer.parseInt(JOptionPane.showInputDialog(null, "Vložte rok vydání"));
        int cena = Integer.parseInt(JOptionPane.showInputDialog(null, "Vložte cenu knihy"));

        try (PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("kniha.txt", true), "windows-1250"))){
            out.println(id + ";" + nazev + ";" + autor + ";" + rok + ";" + cena);
        }

        nactiZeSouboru();
        zobraz();
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Mini pošta");
        EvidenceKnih gui = new EvidenceKnih();
        frame.setContentPane(gui.mainpanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
