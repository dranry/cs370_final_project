import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
public class Poster extends JPanel implements ActionListener{
	private JFrame jf;
	private JTextPane recipe;
	private JTextArea recipeTitle, recipeIngredients, recipeInstructions;
	private JLabel title, ingredients, instructions;
	public static String s1, s2, s3;
	public Poster(JFrame f) {

		jf = f;
		// Need to get database entry for passed ID
        Border blackline = BorderFactory.createLineBorder(Color.black);
        
		JPanel head = new JPanel();
		head.setPreferredSize(new Dimension(RecipeApp.WIDTH - 20, 50));
		
		JPanel left = new JPanel();
		left.setLayout(new FlowLayout(FlowLayout.LEFT));
		left.setPreferredSize(new Dimension(RecipeApp.WIDTH/2 - 15, 45));
		
		JPanel right = new JPanel();
		right.setLayout(new FlowLayout(FlowLayout.RIGHT));
		right.setPreferredSize(new Dimension(RecipeApp.WIDTH/2 - 15, 45));
		
		head.add(left);
		head.add(right);
		
		JButton back = new JButton("Back");
		back.addActionListener(this);
		
		JButton post = new JButton("Post");
		post.addActionListener(this);
		
		left.add(back);
		right.add(new JLabel(RecipeApp.Username));
		right.add(post);
		
		
		JPanel body = new JPanel();
		body.setPreferredSize(new Dimension(RecipeApp.WIDTH - 20, 400));
		body.setBorder(blackline);
		body.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//recipe = new JTextPane();
		//recipe.setPreferredSize(new Dimension(RecipeApp.WIDTH - 40, 380));
		
		recipeTitle = new JTextArea();
		recipeIngredients = new JTextArea();
		recipeInstructions = new JTextArea();
		recipeTitle.setPreferredSize(new Dimension(RecipeApp.WIDTH - 300, 35));
		recipeIngredients.setPreferredSize(new Dimension(RecipeApp.WIDTH - 300, 100));
		recipeInstructions.setPreferredSize(new Dimension(RecipeApp.WIDTH - 300, 240));

		title = new JLabel("Recipe Title");
		ingredients = new JLabel("Ingredients");
		instructions = new JLabel("Instructions and cook method");
		
		//body.add(recipe);
		body.add(recipeTitle);
		body.add(title);
		body.add(recipeIngredients);
		body.add(ingredients);
		body.add(recipeInstructions);
		body.add(instructions);
		
		
		add(head);
		add(body);
	}
	
	public void actionPerformed(ActionEvent e) {
		s1 = recipeTitle.getText();
		s2 = recipeIngredients.getText();
		s3 = recipeInstructions.getText();
		switch(e.getActionCommand()) {
			case "Back":
			try {
				goHome();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
				break;
			case "Post":
				// Post action goes here
			try {
				post();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				goHome();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				break;
			default:
				break;
		}
		
	}
    private void goHome () throws SQLException {
    	jf.getContentPane().removeAll();
    	JPanel h = new Home(jf);
    	jf.getContentPane().add(h);
    	RecipeApp.recipeNumber=1;
    	jf.revalidate();
    }
    private static void post() throws SQLException {
    	DBRecipe.addRecipe(s1, s2, s3);
    }
}
