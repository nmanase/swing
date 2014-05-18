import java.util.Observable;
import java.util.Observer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;


public class ControleurPuissance4Graphique implements Observer {

    private Puissance4 puissance4;
    private JPanel panel = new JPanel();
    private JTextField jtf;

    public ControleurPuissance4Graphique(Puissance4 puissance4) {
        this.puissance4 = puissance4;
        this.puissance4.addObserver(this);
        JFrame frame = new JFrame("Controleur");
        this.jtf = new JTextField(1);
        this.panel.add(new JLabel("Colonne :"));
        this.jtf.addKeyListener(new Ecouteur());
        this.panel.add(jtf);

        frame.setContentPane(this.panel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(170, 170);
        frame.setVisible(true);


    }

    public void update(Observable observable, Object o) {
        this.jtf.setText("");
    }

    class Ecouteur extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                System.out.println("ouaip");
                String content = ControleurPuissance4Graphique.this.jtf.getText();
                if(content != null)
                    try {
                        ControleurPuissance4Graphique.this.puissance4.joueColonne(Integer.parseInt(content));
                    } catch(Exception exception) {
                        System.out.println(exception.getMessage());
                        ControleurPuissance4Graphique.this.jtf.setText("");
                    }
                else ControleurPuissance4Graphique.this.jtf.setText("");
            }
        }
    }
}
