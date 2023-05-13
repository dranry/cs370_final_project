import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Login extends JPanel implements ActionListener {
	private JButton b;
	private JFrame jf;
	public Login(JFrame f) {
		jf = f;
	    b = new JButton("Login");
	    b.addActionListener(this);
	    
	    
		add(b);
	}
    public void actionPerformed(ActionEvent e) {
    	
    	jf.getContentPane().removeAll();
    	JPanel h = new Home(jf);
    	jf.getContentPane().add(h);
    	jf.revalidate();
    }
}
