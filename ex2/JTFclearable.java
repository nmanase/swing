import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.*;
import javax.swing.*;


public class JTFclearable extends JTextField{

	public JTFclearable(String s, int n) {
		super(s, n);
		this.addMouseListener(new JTFclearableAdapter());
	}


	class JTFclearableAdapter extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			JTFclearable.this.setText("");
		}
	}

}