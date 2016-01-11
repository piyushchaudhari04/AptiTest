package panels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DoubleDip extends JPanel {

	
	private static final long serialVersionUID = 1L;
	JButton ddbtn;
	private boolean activated;
	public DoubleDip() {
		ddbtn=new JButton();
		ddbtn.setIcon(new ImageIcon(BingoPanel.class.getResource("/images/double.jpg")));
		setLayout(new BorderLayout());
		add(ddbtn);
		ddbtn.setFont(new Font("Monotype Corsiva", Font.PLAIN, 26));
		ddbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				performAction();
				ddbtn.setEnabled(false);
			}
		});
	
	}
	public void performAction() {
		
		setActivated(true);
		JOptionPane.showMessageDialog(null, "Double Dip Activated");
	}
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	

}
