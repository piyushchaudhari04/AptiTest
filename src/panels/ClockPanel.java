package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import main.MainFrame;

public class ClockPanel extends JPanel implements Runnable{
	
	
	private static final long serialVersionUID = 1L;
	JLabel lblTimeLim;
	private int limit;
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	boolean isOver;
	MainFrame m;
	public ClockPanel(int limit, MainFrame mainFrame){
		
		super(new BorderLayout());
		this.limit=limit;
		
		m=mainFrame;
		JPanel bak=new JPanel(null);
		add(bak);
		
		JLabel lblScore = new JLabel("TIME");
		lblScore.setForeground(new Color(128, 0, 0));
		lblScore.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		lblScore.setBounds(51, 24, 120, 29);
		bak.add(lblScore);
		
		
		lblTimeLim = new JLabel(getTime());
		lblTimeLim.setForeground(new Color(128, 0, 0));
		lblTimeLim.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		lblTimeLim.setBounds(60, 80, 100, 29);
		bak.add(lblTimeLim);
		
		Thread t=new Thread(this);
		t.start();
	}

	public String getTime() {
		int min=limit/60;
		int sec=limit%60;
		if(sec<10)
			return min+":0"+sec;
		else
			return min+":"+sec;
	}

	public void run() {
		
		while(!isOver){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			limit--;
			if(limit<10)
				lblTimeLim.setForeground(Color.RED);
			lblTimeLim.setText(getTime());
			if(limit<=0){
				isOver=true;
				m.endQuiz();
			}
		}
	}
	public static void main(String[] args) {
		
		create();
		
	}

	public static void create() {
		JFrame f=new JFrame("Score");
		f.add(new ClockPanel(20,null));
		WindowUtil.setToCenter(f, 800, 600);
		f.setVisible(true);
		
	}

}


