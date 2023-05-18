
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.*;

public class Home extends JPanel implements ActionListener{	
	private JFrame jf;
	private JButton search_button, my_recipes, new_post;
	private JTextField search_box;
	private JLabel username;
	private JPanel search_field;
	private Result results[];
	public static String [] key;
	public static int [] key1;
	
	public Home(JFrame f) throws SQLException {
		jf = f;
    	jf.getContentPane().removeAll();
    	
	    results = new Result[6];
		
		search_field = new JPanel();
		
		username = new JLabel("Username: " + RecipeApp.Username);		
		search_field.add(username);
		
		my_recipes = new JButton("My Recipes");
		search_field.add(my_recipes);
		my_recipes.addActionListener(this);
		
		search_box = new JTextField();
		search_box.setPreferredSize(new Dimension(300, 20));
		
	    search_button = new JButton("Search");
	    search_button.addActionListener(this);
	    
	    search_field.add(search_box);
	    search_field.add(search_button);
	    
	    new_post = new JButton("New Post");
	    new_post.addActionListener(this);
	    search_field.add(new_post);
	    
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
			try {
				search();
				
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
    			break;
    		case "My Recipes":
    			// search database for posts from this user then update results
			try {
				MyRecipes();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
    			break;
    		case "Details 1":
    			// Switch to viewer for recipe assigned to first button
    			//System.out.println("Test");
    			RecipeApp.recipeNumber = 1;
			try {
				goViewer(RecipeApp.recipeNumber);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    			break;
    		case "Details 2":
    			// Switch to viewer for second recipe
    			RecipeApp.recipeNumber = 2;
			try {
				goViewer(RecipeApp.recipeNumber);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    			break;
    		case "Details 3":
    			// Switch to viewer for third recipe
    			RecipeApp.recipeNumber = 3;
			try {
				goViewer(RecipeApp.recipeNumber);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    			break;
    		case "Details 4":
    			// Switch to viewer for fourth recipe
    			RecipeApp.recipeNumber = 4;
			try {
				goViewer(RecipeApp.recipeNumber);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    			break;
    		case "Details 5":
    			// Switch to viewer for fifth recipe
    			RecipeApp.recipeNumber = 5;
			try {
				goViewer(RecipeApp.recipeNumber);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    			break;
    		case "Details 6":
    			// Switch to viewer for sixth recipe
    			RecipeApp.recipeNumber = 6;
			try {
				goViewer(RecipeApp.recipeNumber);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    			break;
    		case "New Post":
    			goPoster();
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
    private void populateResults() throws SQLException {
	    for(int i = 0; i < 6; i++) { 
	    	key = DBRecipe.pullRecipe(RecipeApp.recipeNumber);
		    RecipeApp.recipeNumber++;
	    	results[i] = new Result(i, key);
	    }
    }
    private void goViewer (int ID) throws SQLException {
    	jf.getContentPane().removeAll();
    	JPanel h = new Viewer(jf, ID);
    	jf.getContentPane().add(h);
    	jf.revalidate();
    }
    private void goPoster() {
    	jf.getContentPane().removeAll();
    	JPanel h = new Poster(jf);
    	jf.getContentPane().add(h);
    	jf.revalidate();
    }
    private void search() throws SQLException {
    	String s1 = search_box.getText();
    	key1 = DBRecipe.searchRecipe(s1);
    	for (int i = 0; i<6; i++) {
    		key = DBRecipe.pullRecipe(key1[i]);
    		results[i] = new Result(i, key);
    	}
    }
    private void MyRecipes() throws SQLException {
    	String s1 = RecipeApp.Username;
    	key1 = DBRecipe.myRecipe(s1);
    	for (int i = 0; i<6; i++) {
    		key = DBRecipe.pullRecipe(key1[i]);
    		results[i] = new Result(i, key);
    	}
    }
}
