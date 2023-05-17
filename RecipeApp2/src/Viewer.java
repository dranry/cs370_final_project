
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
	public Viewer (JFrame f, int ID) {
		jf = f;
		// Need to get database entry for passed ID
        Border blackline = BorderFactory.createLineBorder(Color.black);
        
		String recipe = "This is a\ntest recipe\nwhere things will be interesting\nTest";
		
		JPanel head = new JPanel();
		head.setPreferredSize(new Dimension(RecipeApp.WIDTH - 20, 50));
		
		JPanel body = new JPanel();
		body.setPreferredSize(new Dimension(RecipeApp.WIDTH - 20, 400));
		body.setBorder(blackline);
		//body.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JButton back = new JButton("Back");
		back.addActionListener(this);
		
		head.add(back);
		
		
		StringTokenizer st = new StringTokenizer(recipe, "\n");
		while(st.hasMoreTokens()) {
			JPanel temp = new JPanel();
			temp.setLayout(new FlowLayout(FlowLayout.LEFT));
			temp.add(new JLabel(st.nextToken(), JLabel.LEFT));
			temp.setPreferredSize(new Dimension(RecipeApp.WIDTH - 30, 20));
			body.add(temp);
		}
		add(head);
		add(body);
		
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
    	jf.getContentPane().removeAll();
    	JPanel h = new Home(jf);
    	jf.getContentPane().add(h);
    	jf.revalidate();
    }
}
