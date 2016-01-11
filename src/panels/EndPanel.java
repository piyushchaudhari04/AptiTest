package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.LoginPanel;

public class EndPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	

	EndPanel(String un, int score,int r,int w,int qa){
		super(new BorderLayout());
		//JPanel bak=new JPanel(null);
		JLabel bak=new JLabel(new ImageIcon(LoginPanel.class.getResource("/images/LoginPnl.jpg")));
		bak.setLayout(null);
		add(bak);
		
		JLabel lblScore = new JLabel("SCORE");
		lblScore.setForeground(new Color(128, 0, 0));
		lblScore.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		lblScore.setBounds(330, 117, 120, 29);
		bak.add(lblScore);
		
		lblScore = new JLabel(""+score);
		lblScore.setForeground(new Color(128, 0, 0));
		lblScore.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		lblScore.setBounds(350, 157, 120, 29);
		bak.add(lblScore);
		JLabel lbltestdetails = new JLabel(""+"*TEST DETAILS*");
		lbltestdetails.setForeground(new Color(128, 0, 0));
		lbltestdetails.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		lbltestdetails.setBounds(247, 260, 339, 80);
		bak.add(lbltestdetails);
		JLabel lblqa = new JLabel(""+"#questions attempted -> "+qa+"/30");
		lblqa.setForeground(new Color(128, 0, 0));
		lblqa.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		lblqa.setBounds(265, 337, 330, 50);
		bak.add(lblqa);
		JLabel lblrq = new JLabel(""+"#Right questions ->"+r+"/"+qa);
		lblrq.setForeground(new Color(128, 0, 0));
		lblrq.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		lblrq.setBounds(265, 380, 300, 50);
		bak.add(lblrq);
		JLabel lblwq = new JLabel(""+"#Wrong questions -> "+w+"/"+qa);
		lblwq.setForeground(new Color(128, 0, 0));
		lblwq.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		lblwq.setBounds(265, 428, 300, 50);
		bak.add(lblwq);
		
		JLabel lblUsername = new JLabel("Username :"+un);
		lblUsername.setForeground(new Color(128, 0, 0));
		lblUsername.setFont(new Font("Monotype Corsiva", Font.BOLD, 28));
		lblUsername.setBounds(235, 197, 330, 50);
		bak.add(lblUsername);
		
		setSize(800,600);
		
	}
	public static void main(String[] args) {
		
		create("",10,10,5,5);
		
	}

	public static void create(String un,int score,int r,int w,int qa) {
		JFrame f=new JFrame("Score");
		f.getContentPane().add(new EndPanel(un,score,r,w,qa));
		f.setResizable(false);
		WindowUtil.setToCenter(f, 800, 600);
		f.setVisible(true);
		
	}
}
