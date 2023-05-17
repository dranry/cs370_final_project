
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Home extends JPanel implements ActionListener{	
	private JFrame jf;
	private JButton search_button, my_recipes;
	private JTextField search_box;
	private JLabel username;
	private JPanel search_field;
	private Result results[];
	
	public Home(JFrame f) {
		jf = f;
    	jf.getContentPane().removeAll();
    	
	    results = new Result[6];
		
		search_field = new JPanel();
		
		username = new JLabel("Username: " + RecipeApp.Username);		
		search_field.add(username);
		
		my_recipes = new JButton("My Recipes");
		search_field.add(my_recipes);
		
		search_box = new JTextField();
		search_box.setPreferredSize(new Dimension(300, 20));
		
	    search_button = new JButton("Search");
	    
	    search_field.add(search_box);
	    search_field.add(search_button);
	    
	    search_field.setPreferredSize(new Dimension(RecipeApp.WIDTH, 40));
	    
	    add(search_field);
	    
	    JPanel navigation = new JPanel();
	    navigation.add(new JLabel("Number of Pages: "));
	    
	    JButton next = new JButton("->");
	    
	    next.addActionListener(this);
	    navigation.add(next);
	    
	    populateResults();
	    
	    for(Result r : results) {
	    	r.details.addActionListener(this);
	    	add(r);
	    }
	    
	    add(navigation);
	}
    public void actionPerformed(ActionEvent e) {
    	switch(e.getActionCommand()) {
    		case "Search":
    			break;
    		case "My Recipes":
    			// search database for posts from this user then update results
    			break;
    		case "Details 1":
    			// Switch to viewer for recipe assigned to first button
    			//System.out.println("Test");
    			break;
    		case "Details 2":
    			// Switch to viewer for second recipe
    			break;
    		case "Details 3":
    			// Switch to viewer for third recipe
    			break;
    		case "Details 4":
    			// Switch to viewer for fourth recipe
    			break;
    		case "Details 5":
    			// Switch to viewer for fifth recipe
    			break;
    		case "Details 6":
    			// Switch to viewer for sixth recipe
    			break;
    		case "->":
    			for(Result r : results) {
    				r.title.setText("WOO");
    			}
    			break;
    		default:
    			break;
    	}
    }
    private void populateResults() {
	    for(int i = 0; i < 6; i++) 
	    	results[i] = new Result(i);
    }
}
