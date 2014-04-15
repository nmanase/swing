import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.*;
import javax.swing.*;


public class JTFclearable extends JTextField implements MouseListener{

	public JTFclearable(String s, int n) {
		super(s, n);
		this.addMouseListener(this);
	}

	public void mouseClicked(MouseEvent e) {
		this.setText("");
	}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

}