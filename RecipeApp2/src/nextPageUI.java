import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.*;

public class nextPageUI extends JPanel implements ActionListener{	
	private JFrame jf;
	private JButton back;
	private JLabel username;
	private JTextField search_box;
	private JPanel search;
	private Result results[];
	public static String searchbox;
	public static String [] key;
	public static int [] key1;
	
	public nextPageUI(JFrame f) throws SQLException {
		jf = f;
    	jf.getContentPane().removeAll();
    	
    	results = new Result[6];
    	
    	search = new JPanel();
		
		username = new JLabel("Username: " + RecipeApp.Username);		
		search.add(username);
		
		JButton my_recipes = new JButton("My Recipes");
		JPanel search_field = new JPanel();
		search_field.add(my_recipes);
		my_recipes.addActionListener(this);
		
		search_box = new JTextField();
		search_box.setPreferredSize(new Dimension(300, 20));
		
	    JButton search_button = new JButton("Search");
	    search_button.addActionListener(this);
	    
	    search_field.add(search_box);
	    search_field.add(search_button);
	    
	    JButton new_post = new JButton("New Post");
	    new_post.addActionListener(this);
	    search_field.add(new_post);
	    
	    search_field.setPreferredSize(new Dimension(RecipeApp.WIDTH, 40));
	    
	    add(search_field);

		
	    JPanel navigation = new JPanel();
	    
	    JButton back = new JButton("<-");
	    back.addActionListener(this);
	    
	    JButton next = new JButton("->");
	    next.addActionListener(this);
	    
	    navigation.add(back);
	    navigation.add(new JLabel("Number of Pages: "));
	    navigation.add(next);
	    
	    populateResults();
	    
	    for(Result r : results) {
	    	r.details.addActionListener(this);
	    	add(r);
	    }
	    
	    add(navigation);
	    searchbox = search_box.getText();
	}

	   public void actionPerformed(ActionEvent e) {
	    	searchbox = search_box.getText();
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
				try {
					goViewer(7);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    			break;
	    		case "Details 2":
	    			// Switch to viewer for second recipe
				try {
					goViewer(8);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    			break;
	    		case "Details 3":
	    			// Switch to viewer for third recipe
				try {
					goViewer(9);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    			break;
	    		case "Details 4":
	    			// Switch to viewer for fourth recipe
				try {
					goViewer(10);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    			break;
	    		case "Details 5":
	    			// Switch to viewer for fifth recipe
				try {
					goViewer(11);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    			break;
	    		case "Details 6":
	    			// Switch to viewer for sixth recipe
				try {
					goViewer(12);
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
	    				r.title.setText("");
	    				r.username.setText("");
	    			}
	    			break;
	    		case "<-":
	    			try {
	    				goHome();
	    			} catch (SQLException e2) {
	    				// TODO Auto-generated catch block
	    				e2.printStackTrace();
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
    	jf.getContentPane().removeAll();
    	JPanel h = new SearchUI(jf, searchbox);
    	jf.getContentPane().add(h);
    	jf.revalidate();
    	
    	/*String s1 = search_box.getText();
    	key1 = DBRecipe.searchRecipe(s1);
    	for (int i = 0; i<6; i++) {
    		key = DBRecipe.pullRecipe(key1[i]);
    		results[i] = new Result(i, key);
    	}
    	*/
    }
    private void MyRecipes() throws SQLException {
    	jf.getContentPane().removeAll();
    	JPanel h = new myRecipeUI(jf);
    	jf.getContentPane().add(h);
    	jf.revalidate();
    }
    private void goHome () throws SQLException {
    	RecipeApp.recipeNumber=1;
    	jf.getContentPane().removeAll();
    	JPanel h = new Home(jf);
    	jf.getContentPane().add(h);
    	jf.revalidate();
    }
}
