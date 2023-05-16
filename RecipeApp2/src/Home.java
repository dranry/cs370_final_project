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
	private JPanel results[];
	
	public Home(JFrame f) {
		jf = f;
		
		results = new JPanel[6];
		
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
	    
	    for(int i = 0; i < 6; i++) {
	        Border blackline = BorderFactory.createLineBorder(Color.black);
	        
	    	results[i] = new JPanel();
	    	JPanel left = new JPanel();
	    	left.setPreferredSize(new Dimension((RecipeApp.WIDTH)/3 - 20, (RecipeApp.HEIGHT - 180)/6));
	    	
	    	JPanel center = new JPanel();
	    	center.setPreferredSize(new Dimension(RecipeApp.WIDTH/3 - 20, (RecipeApp.HEIGHT - 180)/6));
	    	
	    	
	    	JPanel right = new JPanel();
	    	right.setPreferredSize(new Dimension(RecipeApp.WIDTH/3 - 20, (RecipeApp.HEIGHT - 180)/6));
	    	
	    	JLabel test = new JLabel("Username");
	    	test.setPreferredSize(new Dimension(225,30));
	    	left.add(test);
	    	
	    	center.add(new JLabel("Recipe Title"));
	    	
	    	JButton details = new JButton("Details " + i);
	    	details.setPreferredSize(new Dimension(210, 90));
	    	right.add(details);

	    	results[i].add(left);
	    	results[i].add(center);
	    	results[i].add(right);
	    	results[i].setBorder(blackline);
	    	
	    	results[i].setPreferredSize(new Dimension(RecipeApp.WIDTH - 30, (RecipeApp.HEIGHT - 170)/6));
	    	add(results[i]);
	    }
	    
	    JPanel navigation = new JPanel();
	    navigation.add(new JLabel("Number of Pages"));
	    navigation.add(new JButton("Next Page"));
	    
	    add(navigation);
	}
    public void actionPerformed(ActionEvent e) {
    	switch(e.getActionCommand()) {
    		case "Search":
    			break;
    		case "My Recipes":
    			break;
    		case "Details 1":
    			break;
    		case "Details 2":
    			break;
    		case "Details 3":
    			break;
    		case "Details 4":
    			break;
    		case "Details 5":
    			break;
    		case "Details 6":
    			break;
    		case "Next Page":
    			break;
    		default:
    			break;
    	}
    }
}
