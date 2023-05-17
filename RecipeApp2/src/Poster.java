import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
public class Poster extends JPanel implements ActionListener{
	private JFrame jf;
	private JTextPane recipe;
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
		
		left.add(back);
		right.add(new JLabel(RecipeApp.Username));
		
		
		JPanel body = new JPanel();
		body.setPreferredSize(new Dimension(RecipeApp.WIDTH - 20, 400));
		body.setBorder(blackline);
		body.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		recipe = new JTextPane();
		recipe.setPreferredSize(new Dimension(RecipeApp.WIDTH - 40, 380));
		
		body.add(recipe);
		
		add(head);
		add(body);
	}
	
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Back":
				goHome();
				break;
			case "Post":
				// Post action goes here
				break;
			default:
				break;
		}
		
	}
    private void goHome () {
    	jf.getContentPane().removeAll();
    	JPanel h = new Home(jf);
    	jf.getContentPane().add(h);
    	jf.revalidate();
    }
}
