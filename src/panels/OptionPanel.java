package panels;
import java.awt.*;

import javax.swing.*;
public class OptionPanel extends JPanel{
	
	
		private static final long serialVersionUID = 1L;
		private JRadioButton rb2;
		private JRadioButton rb4;
		private JRadioButton rb3;
		private JRadioButton rb1;
		private ButtonGroup bg;
		public OptionPanel(){
		
		setBounds(250,370,750,200);
		setLayout(new GridLayout(0,1,5,5));
		bg=new ButtonGroup();
		
		rb1=new JRadioButton("A");
		rb1.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		rb2=new JRadioButton("B");
		rb2.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		rb3=new JRadioButton("C");
		rb3.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		rb4=new JRadioButton("D");
		rb4.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		bg.add(rb4);

		add(rb1);
		//add(new JSeparator(JSeparator.HORIZONTAL));
		add(rb2);
		//add(new JSeparator(JSeparator.HORIZONTAL));
		add(rb3);
		//add(new JSeparator(JSeparator.HORIZONTAL));
		add(rb4);

	}
	public void showOptions(String [] para){
		
		rb1.setText("A."+para[0]);
		rb2.setText("B."+para[1]);
		rb3.setText("C."+para[2]);
		rb4.setText("D."+para[3]);
	}
	public boolean checkAns(char ans){
		
		boolean ck=false;
		if(ans=='A'&&rb1.isSelected()||ans=='B'&&rb2.isSelected()||ans=='C'&&rb3.isSelected()||ans=='D'&&rb4.isSelected())
		{	ck=true;
		}
		
		bg.clearSelection();
		return ck;
	}
	public boolean isSelected(){
		return rb1.isSelected()||rb2.isSelected()||rb3.isSelected()||rb4.isSelected();
	}
	public static void main(String[] args) {
		
		create();
		
	}

	public static void create() {
		JFrame f=new JFrame("Score");
		f.add(new OptionPanel());
		WindowUtil.setToCenter(f, 800, 600);
		f.setVisible(true);
		
	}
	public int selectedOption(){
		int sel=-1;
		if(rb1.isSelected())
			sel=0;
		else if(rb2.isSelected())
			sel=1;
		else if(rb3.isSelected())
			sel=2;
		else if(rb4.isSelected())
			sel=3;
			
		return sel;
	}

}
