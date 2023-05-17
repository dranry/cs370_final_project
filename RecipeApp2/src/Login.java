
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.*;


import javax.swing.*;
public class Login extends JPanel implements ActionListener {
	private JButton login_button, create_account_button;
	private JFrame jf;
	private JTextField uname;
	private JPasswordField pword;
	private JLabel un, pw;
	public static String s1, s2;
	public Login(JFrame f) {
		jf = f;
		
		setLayout(null);
		
		uname = new JTextField();
		uname.setBounds(270, 200, 250, 30);
		
		pword = new JPasswordField();
		pword.setBounds(270, 250, 250, 30);
		
		un = new JLabel("Username:");
		un.setBounds(200, 200, 250, 30);
		
		pw = new JLabel("Password:");
		pw.setBounds(200, 250, 250, 30);
		
	    login_button = new JButton("Login");
	    login_button.addActionListener(this);
	    login_button.setBounds(350, 300,75, 30);
		
	    create_account_button = new JButton("Create Account");
	    create_account_button.addActionListener(this);
	    create_account_button.setBounds(310, 330,160, 30);
	    
	    add(uname);
	    add(pword);
		add(pw);
		add(un);
		add(login_button);
		add(create_account_button);
	}
    public void actionPerformed(ActionEvent e) {
    	String s1 = uname.getText();
    	char[] ca = pword.getPassword();
    	String s2 = String.valueOf(ca);
    	switch(e.getActionCommand()) {
    		case "Login":
			goHome();
    		try {
				loginHandler();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    			break;
    		case "Create Account":
			try {
				creationHandler();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    			break;
    		default:
    			break;
    	}
    }
    private void loginHandler() throws SQLException {
    	// Login using database
    	// Check validity of login
    	// Store login username in RecipeApp.Username;
    	if (DBLogin.checkUser(s1, s2)==1) {
    	RecipeApp.Username = s1;
    	goHome();
    	}
    	else {
    		JOptionPane.showMessageDialog(null,"username and password are wrong ");
    	}
    }
    private void creationHandler() throws SQLException {
    	// Create account in db and log in
    	DBLogin.createUser(s1, s2);
    	RecipeApp.Username = s1;
    	goHome();
    }
    private void goHome() {
    	jf.getContentPane().removeAll();
    	JPanel h = new Home(jf);
    	jf.getContentPane().add(h);
    	jf.revalidate();
    }
}
