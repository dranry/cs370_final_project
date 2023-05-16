import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Viewer extends JPanel implements ActionListener {
	JFrame jf;
	public Viewer (JFrame f) {
		jf = f;
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
    private void goHome () {
    	jf.getContentPane().removeAll();
    	JPanel h = new Home(jf);
    	jf.getContentPane().add(h);
    	jf.revalidate();
    }
}
