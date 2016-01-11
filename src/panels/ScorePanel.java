package panels;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
public class ScorePanel extends  JPanel{

	
	private static final long serialVersionUID = 1L;
	JLabel scorelbl;
	private int score;
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public ScorePanel(){
		super(new BorderLayout());
		JPanel bak=new JPanel(null);
		add(bak);
		
		JLabel lblScore = new JLabel("SCORE");
		lblScore.setForeground(new Color(128, 0, 0));
		lblScore.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		lblScore.setBounds(51, 24, 120, 29);
		bak.add(lblScore);
		
		scorelbl = new JLabel(""+score);
		scorelbl.setForeground(new Color(128, 0, 0));
		scorelbl.setFont(new Font("Monotype Corsiva", Font.BOLD, 28));
		scorelbl.setBounds(65, 80, 46, 29);
		bak.add(scorelbl);
		
		
		
	}
	public void increaseScore(int incr){
		score+=incr;
		scorelbl.setText(""+score);
	}
	public void decreaseScore(int decr){
		score-=decr;
		scorelbl.setText(""+score);
	}
}
