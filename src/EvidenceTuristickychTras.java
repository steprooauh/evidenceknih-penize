import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EvidenceTuristickychTras {
    ArrayList<Trasa> seznam = new ArrayList<Trasa>();
    private JTextField nazevF;
    private JLabel label;
    private JTextField pohoriF;
    private JLabel label2;
    private JTextField delkaF;
    private JLabel label3;
    private JTextField prevyseniF;
    private JLabel label4;
    private JTextField obtiznostF;
    private JLabel label5;
    private JButton back;
    private JButton next;
    private JPanel panel;
    private JTextField indexF;
    private JButton add;
    private JButton statistika;
    File file = new File("trasy.txt");
    int index = 0;

    public EvidenceTuristickychTras() throws IOException {
        nacti();
        zobraz();

        back.addActionListener(e -> {
            if (seznam.isEmpty()) return;

            index--;
            if (index < 0) {
                index = seznam.size() - 1;
            }
            zobraz();
        });

        next.addActionListener(e -> {
            if (seznam.isEmpty()) return;

            index++;
            if (index >= seznam.size()) {
                index = 0;
            }
            zobraz();
        });

        add.addActionListener(e -> {
            try {
                pridatTrasu();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (UnsupportedEncodingException ex) {
                throw new RuntimeException(ex);
            }
        });

        statistika.addActionListener(e -> stats());
    }

    public void nacti() throws IOException {
        seznam.clear();
        if (!file.exists()) {
            file.createNewFile();
            return;
        }
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split("\\|");

                if (data.length == 5) {
                    String nazev = data[0];
                    String pohori = data[1];
                    double delka = Double.parseDouble(data[2]);
                    int prevyseni = Integer.parseInt(data[3]);
                    String obtiznost = data[4];

                    Trasa t = new Trasa(nazev, pohori, delka, prevyseni, obtiznost);
                    seznam.add(t);
                }
            }
        }
    }

    public void zobraz() {
        if (seznam.isEmpty()) {
            indexF.setText("0/0");
            return;
        }

        Trasa t = seznam.get(index);
        indexF.setText((index + 1) + " / " + seznam.size());
        nazevF.setText(t.getNazev());
        pohoriF.setText(t.getPohori());
        delkaF.setText(String.valueOf(t.getDelka()));
        prevyseniF.setText(String.valueOf(t.getPrevyseni()));
        obtiznostF.setText(t.getObtiznost());
    }

    public void pridatTrasu() throws FileNotFoundException, UnsupportedEncodingException {
        String nazev = JOptionPane.showInputDialog(null, "Vložte název trasy");
        String pohori = JOptionPane.showInputDialog(null, "Vložte pohoří");
        double delka = Double.parseDouble(JOptionPane.showInputDialog(null, "Vložte délku trasy (příklad 23.5 v km)"));
        int prevyseni = Integer.parseInt(JOptionPane.showInputDialog(null, "Vložte převýšení (příklad 175 bez desetiny)"));
        String obtiznost = JOptionPane.showInputDialog(null, "Vložte obtížnost 1-5");

        Trasa t = new Trasa(nazev, pohori, delka, prevyseni, obtiznost);
        seznam.add(t);

        try (PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("trasy.txt", true), "windows-1250"))){
            out.println(nazev + "|" + pohori + "|" + delka + "|" + prevyseni + "|" + obtiznost);
        }
    }

    public void stats(){
        int trasy = seznam.size();

        if (trasy == 0){
            JOptionPane.showMessageDialog(null, "Žádné trasy v seznamu.");
            return;
        }

        double soucet = 0;
        double max = 0;

        for (int i = 0; i < seznam.size(); i++){
            soucet += seznam.get(i).delka;

            if (seznam.get(i).delka > max){
                max = seznam.get(i).delka;
            }
        }

        double prumer = soucet / trasy;

        JOptionPane.showMessageDialog(null,
                "Statistika\n" +
                        "Celkový počet tras = " + trasy + "\n" +
                        "Průměrná délka = " + prumer + " km\n" +
                        "Nejdelší trasa = " + max + " km"
        );
    }

    public static void main(String[] args) throws IOException {
        JFrame okno = new JFrame("turisticke trasy");
        EvidenceTuristickychTras ett = new EvidenceTuristickychTras();
        okno.setContentPane(ett.panel);
        okno.pack(); // Přizpůsobí velikost obsahu
        okno.setSize(500, 500);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setResizable(false);
        okno.setVisible(true);
    }
}