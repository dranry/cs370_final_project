

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class RecipeApp extends JFrame {
	JButton b, b2, b3;
	public static int id = 0; 
	public static int WIDTH = 800;
	public static int HEIGHT = 800;
	public static String Username;

    public RecipeApp() {
        setTitle("Recipe App");
        setSize(WIDTH, HEIGHT);
        //setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        /*
        JPanel pane = new JPanel();
        JPanel pane2 = new JPanel();
        
        b = new JButton("+");
        b.setPreferredSize(new Dimension(500, 500));
        b2 = new JButton("+");
        b3= new JButton("+");
        
        pane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        pane.add(b);
        pane.add(b2);
        pane.add(b3);
        pane.add(b2);
        */
        Login p = new Login(this);
        add(p);
        
        
    }
    
    public static void main(String[] args) {
        RecipeApp app = new RecipeApp();
        app.setVisible(true);
    }

}
