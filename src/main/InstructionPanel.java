package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import panels.WindowUtil;

public class InstructionPanel extends JPanel {


	private static final long serialVersionUID = 1L;

	JTextArea ta_inst,ta_note;
	JButton start;
	static JFrame f;
	String username,address,portNo;
	

	protected boolean isNovice;
	InstructionPanel(String addr,String port, String un, boolean isNovice)
	{

		super(null);
		username=un;
		address=addr;
		portNo=port;
		this.isNovice=isNovice;
		setBackground(Color.white);
		
		setLayout(new BorderLayout());
		JLabel bak=new JLabel();
		if(isNovice)
			bak.setIcon(new ImageIcon(LoginPanel.class.getResource("/images/novice.jpg")));
		else
			bak.setIcon(new ImageIcon(LoginPanel.class.getResource("/images/Expert.jpg")));
		bak.setLayout(null);
		add(bak);

		
		start=new JButton("Start");
		start.setBounds(650,550,100,40);
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
				int res=JOptionPane.showConfirmDialog(null, "Do you want to start ?");
				if(res!=1&&res!=2){
					new MainFrame(address,portNo,30, username, InstructionPanel.this.isNovice);
					f.setVisible(false);
				}
				
			}
		});
		start.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		bak.add(start);

	}
	public static void main(String[] args) {
		create("","","",true);
	}

	public static void create(String addr,String port, String un, boolean isNovice) {
		f=new JFrame("Instruction");
		f.getContentPane().add(new InstructionPanel(addr,port, un, isNovice));
		f.setResizable(false);
		WindowUtil.setToCenter(f, 800, 640);
		f.setVisible(true);
		
	}

}
