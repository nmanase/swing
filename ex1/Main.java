import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

public class Main {

	public static void main(String args[]){
		JFrame frame =  new JFrame("Exercice1");
		Container container =  frame.getContentPane();
		JTFclearable jtf = new JTFclearable("Texte initial", 50);
		container.add(jtf);
		frame.pack();
		frame.setVisible(true);

	}

}