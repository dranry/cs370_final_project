
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class Viewer extends JPanel implements ActionListener {
	JFrame jf;
	private JLabel title, ingredients, instructions;
	public Viewer (JFrame f, int ID) throws SQLException {
		
		jf = f;
		// Need to get database entry for passed ID
        Border blackline = BorderFactory.createLineBorder(Color.black);
        
		int view = DBRecipe.incrementRecipe(ID);
        
		JPanel head = new JPanel();
		head.setPreferredSize(new Dimension(RecipeApp.WIDTH - 20, 50));
		
		JPanel body = new JPanel();
		body.setPreferredSize(new Dimension(RecipeApp.WIDTH - 20, 400));
		body.setBorder(blackline);

		JPanel foot = new JPanel();
		foot.setPreferredSize(new Dimension(RecipeApp.WIDTH - 20, 50));
		
		JButton back = new JButton("Back");
		back.addActionListener(this);
		
		
		String s=Integer.toString(view);
		JLabel views = new JLabel(s);
		
		JLabel viewCount = new JLabel("Views ");
		
		head.add(back);
		foot.add(views);
		foot.add(viewCount);
		
		
		
		
		//s1, s2, s3 come from sql database columns title
		String [] key = DBRecipe.pullRecipe(ID);
		String s1 = key[0]; // Title
		String s2 = key[1]; // Ingredients
		String s3 = key[2]; // Instructions
		

		JPanel temp = new JPanel();
		JPanel temp2 = new JPanel();
		
		// Adds Title
		temp.setLayout(new FlowLayout(FlowLayout.LEFT));
		temp.add(new JLabel(s1, JLabel.LEFT));
		temp.setPreferredSize(new Dimension(RecipeApp.WIDTH - 30, 20));
		body.add(temp);
		
		// Populates Ingredients
		temp2.setLayout(new FlowLayout(FlowLayout.LEFT));
		temp2.add(new JLabel("Ingredients: ", JLabel.LEFT));
		temp2.setPreferredSize(new Dimension(RecipeApp.WIDTH - 30, 20));
		body.add(temp2);
		
		StringTokenizer st = new StringTokenizer(s2, "\n");
		while(st.hasMoreTokens()) {
			temp = new JPanel();
			temp.setLayout(new FlowLayout(FlowLayout.LEFT));
			temp.add(new JLabel(st.nextToken(), JLabel.LEFT));
			temp.setPreferredSize(new Dimension(RecipeApp.WIDTH - 30, 20));
			body.add(temp);
		}
		
		// Populates Instructions
		temp2 = new JPanel();
		temp2.setLayout(new FlowLayout(FlowLayout.LEFT));
		temp2.add(new JLabel("Instructions:", JLabel.LEFT));
		temp2.setPreferredSize(new Dimension(RecipeApp.WIDTH - 30, 20));
		body.add(temp2);
		
		st = new StringTokenizer(s3, "\n");
		while(st.hasMoreTokens()) {
			temp = new JPanel();
			temp.setLayout(new FlowLayout(FlowLayout.LEFT));
			temp.add(new JLabel(st.nextToken(), JLabel.LEFT));
			temp.setPreferredSize(new Dimension(RecipeApp.WIDTH - 30, 20));
			body.add(temp);
		}
		
		//title = new JLabel(s1);
		//ingredients = new JLabel(s2);
		//instructions = new JLabel(s3);
		//title.setLayout(getLayout());
		
		//body.add(recipe);
		//body.add(title);
		//body.add(ingredients);
		//body.add(instructions);
		
		add(head);
		add(body);
		add(foot);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Back":
			try {
				goHome();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				break;
		}
		
	}
    private void goHome () throws SQLException {
    	RecipeApp.recipeNumber = 1;
    	jf.getContentPane().removeAll();
    	JPanel h = new Home(jf);
    	jf.getContentPane().add(h);
    	jf.revalidate();
    }
}
