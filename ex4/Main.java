import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.*;
import javax.swing.*;

public class Main {

	public static void main(String args[]){
		int param = Integer.parseInt(args[0]) + 1;

		JFrame frame =  new JFrame("Exercice3");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container =  frame.getContentPane();

		container.setLayout(new FlowLayout());

		Jtf jtf =  new Jtf("Texte", 50);
		JButton b = new JButton("Effacer");
		b.addMouseListener(jtf);

		container.add(jtf);
		container.add(b);

		frame.pack();
		frame.setVisible(true);

	}
}

class Jtf extends JTextField implements MouseListener {

	public Jtf(String s, int n){
		super(s, n);
	}

	public void mouseClicked(MouseEvent e) {
		this.setText("");
	}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

}