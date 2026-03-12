import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Penize {
    private JTextArea vypsani;
    private JPanel panel1;
    private JLabel nadpis;
    private JButton vypni;
    private JButton oprav;
    private JButton restart;

    public int index = 0;

    private ArrayList<Pracovnici> seznam = new ArrayList<Pracovnici>();

    public Penize(){
        ziskaniSouboru();
        vypsaniTextu();

        vypni.addActionListener(e -> exit());
        oprav.addActionListener(e -> {
            try {
                editovat();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        restart.addActionListener(e -> restart());
    }

    public void ziskaniSouboru() {
        try (Scanner sc = new Scanner(new File("penize.txt"))){
            while (sc.hasNextLine()) {
                String radek = sc.nextLine();
                String[] data = radek.split(";");

                if (data.length == 3){
                    String popis = data[0];
                    double mzda = Double.parseDouble(data[1]);
                    int pocet = Integer.parseInt(data[2]);

                    Pracovnici p = new Pracovnici(popis, mzda, pocet);
                    seznam.add(p);
                }
            }
        } catch (FileNotFoundException e){
            problem();
        }
    }

    public void vypsaniTextu(){
        vypsani.append("Obsah souboru:\n\n");
        for (int a = 0; a < seznam.size(); a++) {
            Pracovnici p = seznam.get(a);
            int poradi = a + 1;
            vypsani.append(poradi + ") " + p.popis + ": " + p.pocet + " osob (" + p.mzda + "Kč/hod) \n");
        }
    }

    public void exit(){
        JOptionPane.showMessageDialog(null, "Na shledanou a naviděnou příště!");
        System.exit(0);
    }

    public void editovat() throws IOException {
        File f = new File("penize.txt");
        Desktop d = Desktop.getDesktop();

        if (f.exists()){
            d.open(f);
        } else {
            problem();
        }
    }

    public void problem(){
        JOptionPane.showMessageDialog(null, "Vložte soubor s názvem penize.txt, tři údaje: popis práce;mzda na hodinu;počet pracovníků \n Příklad: zalívání;100;5");
        System.exit(0);
    }

    public void restart(){
        JFrame okno = (JFrame) SwingUtilities.getWindowAncestor(panel1);
        okno.dispose();
        main();
    }

    static void main() {
        JFrame okno = new JFrame("Money");
        okno.setSize(400, 600);
        okno.setResizable(false);
        Penize penize = new Penize();
        okno.setContentPane(penize.panel1);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setVisible(true);
    }
}
