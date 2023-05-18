import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.*;

public class SearchUI extends JPanel implements ActionListener{	
	private JFrame jf;
	private JButton back;
	private JLabel username;
	private JPanel search;
	private Result results[];
	public static String [] key;
	public static int [] key1;
	
	public SearchUI(JFrame f, String s1) throws SQLException {
		jf = f;
    	jf.getContentPane().removeAll();
    	
    	results = new Result[6];
    	
    	search = new JPanel();
		
		username = new JLabel("Username: " + RecipeApp.Username);		
		search.add(username);
		
		JPanel navigation = new JPanel();
	    navigation.add(new JLabel("Go back: "));
	    
	    back = new JButton("<-");
	    
	    back.addActionListener(this);
	    navigation.add(back);
	    
	    populateResults(s1);
	    
	    for(Result r : results) {
	    	r.details.addActionListener(this);
	    	add(r);
	    }
	    
	    add(navigation);
		/*key1 = DBRecipe.searchRecipe(s1);
    	for (int i = 0; i<6; i++) {
    		key = DBRecipe.pullRecipe(key1[i]);
    		results[i] = new Result(i, key);
    	}*/
	    
	}

	@Override
    public void actionPerformed(ActionEvent e) {
    	switch(e.getActionCommand()) {
    		case "Details 1":
    			// Switch to viewer for recipe assigned to first button
    			//System.out.println("Test");
			try {
				goViewer(key1[0]);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    			break;
    		case "Details 2":
    			// Switch to viewer for second recipe
			try {
				goViewer(key1[1]);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    			break;
    		case "Details 3":
    			// Switch to viewer for third recipe
			try {
				goViewer(key1[2]);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    			break;
    		case "Details 4":
    			// Switch to viewer for fourth recipe
			try {
				goViewer(key1[3]);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    			break;
    		case "Details 5":
    			// Switch to viewer for fifth recipe
			try {
				goViewer(key1[4]);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    			break;
    		case "Details 6":
    			// Switch to viewer for sixth recipe
			try {
				goViewer(key1[5]);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
    	}
	}
	private void populateResults(String s1) throws SQLException {
	    	key1 = DBRecipe.searchRecipe(s1);
	    	for (int x = 0; x<6; x++) {
	    		key = DBRecipe.pullRecipe(key1[x]);
	    		results[x] = new Result(x, key);
	    		}
	}
    private void goHome () throws SQLException {
    	RecipeApp.recipeNumber=1;
    	jf.getContentPane().removeAll();
    	JPanel h = new Home(jf);
    	jf.getContentPane().add(h);
    	jf.revalidate();
    }
    private void goViewer (int ID) throws SQLException {
    	jf.getContentPane().removeAll();
    	JPanel h = new Viewer(jf, ID);
    	jf.getContentPane().add(h);
    	jf.revalidate();
    }
}
