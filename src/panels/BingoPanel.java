package panels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import main.MainFrame;

public class BingoPanel extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private MainFrame mf;
	JButton bingoBtn;
	public BingoPanel(MainFrame m) {
		mf=m;
		bingoBtn=new JButton();
		bingoBtn.setBorder(UIManager.getBorder("TitledBorder.border"));
		bingoBtn.setIcon(new ImageIcon(BingoPanel.class.getResource("/images/bingo2.jpg")));
		setLayout(new BorderLayout());
		add(bingoBtn);
		bingoBtn.setFont(new Font("Monotype Corsiva", Font.PLAIN, 26));
		bingoBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				performAction();
				bingoBtn.setEnabled(false);
				
			}
		});
	}
	public void performAction() {
		char ch=mf.getAns();
		JOptionPane.showMessageDialog(null, "Correct Answer "+ch);
	}
	

}
