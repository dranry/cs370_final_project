
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;

public class Result extends JPanel{
	public JLabel title, username;
	public JButton details;
	public int ID;
	
	public Result(int i, String[] key) throws SQLException {//, int identification) {
		//ID = 0;
		
		//String [] key = DBRecipe.pullRecipe(RecipeApp.recipeNumber);
		//RecipeApp.recipeNumber++;
		String user = key[3];
		String recipe = key[0];
		
		System.out.println(recipe);
		
        Border blackline = BorderFactory.createLineBorder(Color.black);
        
		JPanel left = new JPanel();
    	left.setPreferredSize(new Dimension((RecipeApp.WIDTH)/3 - 20, (RecipeApp.HEIGHT - 220)/6));
    	
    	JPanel center = new JPanel();
    	center.setPreferredSize(new Dimension(RecipeApp.WIDTH/3 - 20, (RecipeApp.HEIGHT - 220)/6));
    	
    	
    	JPanel right = new JPanel();
    	right.setPreferredSize(new Dimension(RecipeApp.WIDTH/3 - 20, (RecipeApp.HEIGHT - 220)/6));
    	

    	username = new JLabel(user);
    	username.setPreferredSize(new Dimension(225,30));
    	left.add(username);
    	
    	title = new JLabel(recipe);
    	center.add(title);
    	
    	details = new JButton("Details " + (i + 1));
    	details.setPreferredSize(new Dimension(210, 90));
    	right.add(details);

    	add(left);
    	add(center);
    	add(right);
    	

    	setBorder(blackline);
    	
    	setPreferredSize(new Dimension(RecipeApp.WIDTH - 30, (RecipeApp.HEIGHT - 170)/6));
	}			
	

}
