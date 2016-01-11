package panels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.MainFrame;

public class Fiftyfifty extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private MainFrame mf;
	JButton ffbtn;
	public Fiftyfifty(MainFrame m) {
		mf=m;
		ffbtn=new JButton();
		ffbtn.setIcon(new ImageIcon(BingoPanel.class.getResource("/images/50_50.jpg")));
		setLayout(new BorderLayout());
		add(ffbtn);
		ffbtn.setFont(new Font("Monotype Corsiva", Font.PLAIN, 26));
		ffbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				performAction();
				ffbtn.setEnabled(false);
				
			}
		});
	}
	public void performAction() {
		char ch=mf.getAns();
		char op1,op2;
		if(ch=='A')
		{
			op1='B';op2='C';
		}
		else if(ch=='B'){
			op1='A';op2='D';
		}
		else if(ch=='C'){
			op1='B';op2='D';
		}
		else {
			op1='A';op2='C';
		}
		JOptionPane.showMessageDialog(null, "Wrong Ans "+op1+" & "+op2);
	}
	

}
