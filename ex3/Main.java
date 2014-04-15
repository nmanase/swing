import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
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

		JTFListener list = new JTFListener();

		for (int i=1; i<param; i++) {
			JTextField jtf = new JTextField("Texte initial"+i, 50);
			jtf.addMouseListener(list);
			container.add(jtf);
			
		}
		frame.pack();
		frame.setVisible(true);

	}

}

class JTFListener extends MouseAdapter {
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof JTextField)
			((JTextField)e.getSource()).setText("");
	}
}