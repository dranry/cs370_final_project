import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


import javax.swing.*;
public class Login extends JPanel implements ActionListener {
	private JButton login_button, create_account_button;
	private JFrame jf;
	private JTextField uname;
	private JPasswordField pword;
	private JLabel un, pw;
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
    	switch(e.getActionCommand()) {
    		case "Login":
    			loginHandler();
    			break;
    		case "Create Account":
    			creationHandler();
    			break;
    		default:
    			break;
    	}
    }
    private void loginHandler() {
    	// Login using database
    	// Check validity of login
    	// Store login username in RecipeApp.Username;
    	
    	RecipeApp.Username = "test";
    	goHome();
    }
    private void creationHandler() {
    	// Create account in db and log in
    }
    private void goHome() {
    	jf.getContentPane().removeAll();
    	JPanel h = new Home(jf);
    	jf.getContentPane().add(h);
    	jf.revalidate();
    }
}
