package panels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Timepass extends JPanel {

	
	private static final long serialVersionUID = 1L;
	JButton tpbtn;
	private boolean activated;
	public Timepass() {
		tpbtn=new JButton();
		tpbtn.setIcon(new ImageIcon(BingoPanel.class.getResource("/images/boost.jpg")));
		setLayout(new BorderLayout());
		add(tpbtn);
		tpbtn.setFont(new Font("Monotype Corsiva", Font.PLAIN, 26));
		tpbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				performAction();
				tpbtn.setEnabled(false);
			}
		});
	
	}
	public void performAction() {
		
		setActivated(true);
		JOptionPane.showMessageDialog(null, "Time-Boost Activated");
	}
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	

}
