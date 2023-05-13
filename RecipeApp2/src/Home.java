import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JPanel implements ActionListener{	
	private JFrame jf;
	private JButton b;
	public Home(JFrame f) {
		jf = f;
		
	    b = new JButton("This is the Home Page");
	    add(b);
	}
    public void actionPerformed(ActionEvent e) {
    	
    }
}
