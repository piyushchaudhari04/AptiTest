package panels;
import javax.swing.*;

import main.MainFrame;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class QuestionSummary extends JPanel implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	JButton[] quesummary;
	MainFrame mf;
	ArrayList<Integer> queEnab=new ArrayList<Integer>();
	public QuestionSummary(int noofb, MainFrame mainFrame){
		
		quesummary=new JButton[noofb];
		mf=mainFrame;
		setLayout(new GridLayout(6,6,1,1));
		for(int i=0;i<noofb;i++){
			
			quesummary[i]=new JButton(""+(i+1));
			quesummary[i].addActionListener(this);
			add(quesummary[i]);
			queEnab.add(i);
		}
		
	}
	public void disableButton(int i,int pos, boolean isCorrect){
		if(isCorrect)
			quesummary[i].setBackground(Color.green);
		else
			quesummary[i].setBackground(Color.red);
		
		queEnab.remove(pos);
	}
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<quesummary.length;i++){
			if(quesummary[i]==e.getSource()){
				mf.showQuestion(queEnab.indexOf(i));
				mf.setQuepos(queEnab.indexOf(i));
			}
		}
		
	}
	public static void main(String agrs[]){
		WindowUtil.setNimbusLook();
		create();
	}
	public static void create() {
		JFrame f=new JFrame("Score");
		f.add(new QuestionSummary(30, null));
		WindowUtil.setToCenter(f, 400, 400);
		f.setVisible(true);
		
	}
}
