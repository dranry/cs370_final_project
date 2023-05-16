import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
public class Login extends JPanel implements ActionListener {
	private JButton b, b2;
	private JFrame jf;
	JTextField t1, t2;
	public Login(JFrame f) {
		jf = f;
	    b = new JButton("Login");
	    b.addActionListener(this);
	    
	    t1 = new JTextField();
	    t1.setBounds(150,90,90,30);
	    t2 = new JPasswordField();
	    t2.setBounds(150,130,90,30);
	    
	    JLabel user_label = new JLabel("Username:");
	    user_label.setBounds(65,90,90,30);
	    JLabel pass_label = new JLabel("Password:");
	    pass_label.setBounds(65,130,90,30);
	    
	    f.add(user_label);
	    f.add(pass_label);
	    
	    b2 = new JButton("Create new user");
	    b2.setBounds(75,300,200,30);
	    b2.addActionListener(this);
	    
		add(b);
		f.add(t1);
		f.add(t2);
		f.add(b);
		f.add(b2);
		
		jdbc jdbc = new jdbc();
		jdbc.connect();
	}
    public void actionPerformed(ActionEvent e) {
    	//Login button function
    	if(e.getSource()== b) {
    		String s1=t1.getText();
    	    String s2=t2.getText();
			try {
				if (jdbc.checkUser(s1, s2)==1) {
					jf.getContentPane().removeAll();
	    	    	JPanel h = new Home(jf);
	    	    	jf.getContentPane().add(h);
	    	    	jf.revalidate();
				}
				else {
					JOptionPane.showMessageDialog(null,"username and password are wrong ");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		
    		
    		
    		
    		/*String s1=t1.getText();
    	    String s2=t2.getText();
    	    if(s1.compareTo("software") == 0 && s2.compareTo("engineering") == 0) {
    	      System.out.println("success");
    	      jf.getContentPane().removeAll();
    	    	JPanel h = new Home(jf);
    	    	jf.getContentPane().add(h);
    	    	jf.revalidate();
    	    }
    	    else {
    	      System.out.println("unsuccessful");
    	    }
    	    */
    	  }
    	
    	//Create User function from jdbc
    	if(e.getSource() == b2) {
    		String s1=t1.getText();
    	    String s2=t2.getText();
    	    try {
				jdbc.createUser(s1, s2);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
      }
}

