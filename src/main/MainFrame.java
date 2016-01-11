package main;


/**
 * 
 */

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import networking.Client;
import panels.BingoPanel;
import panels.ClockPanel;
import panels.DoubleDip;
import panels.EndPanel;
import panels.Fiftyfifty;
import panels.OptionPanel;
import panels.QuestionSummary;
import panels.ScorePanel;
import panels.Timepass;
import panels.WindowUtil;

public class MainFrame 
{
	private JFrame f;
	//final static 
	
	public JFrame getF() {
		return f;
	}

	public void setF(JFrame f) {
		this.f = f;
	}
	Vector<String> que;
	boolean isCorrect;
	
	JTextArea textarea;
	JScrollPane jsp;
	BingoPanel bingo;
	Fiftyfifty ff;
	DoubleDip dd;
	Timepass tp;
	JButton prev,next,submit;
	ClockPanel cp;
	OptionPanel op=new OptionPanel();
	ScorePanel sp=new ScorePanel();
	QuestionSummary qsp;
	boolean isNovice;
	int attemptQ,wrongQ,rightQ;
	int time=1800;
	List<QuestionDetail> queList=new ArrayList<>();
	public List<QuestionDetail> getQueList() {
		return queList;
	}
	
	public void setQueList(List<QuestionDetail> queList) {
		this.queList = queList;
	}
	private int quepos,noofque,incrScore,decrScore;
	public int getQuepos() {
		return quepos;
	}
	public void setQuepos(int quepos) {
		this.quepos = quepos;
	}
	ArrayList<Integer> quesummary=new ArrayList<Integer>();

	protected int bonus=60;
	private Client client;
	private String username;
	public MainFrame(String address, String portNo, int no,String un,boolean isNovice){
	
		this.noofque=no;
		attemptQ=wrongQ=rightQ=0;
		this.username=un;
		this.isNovice=isNovice;
		f=new JFrame();
		
		incrScore=2;
		decrScore=1;
		setClient(new Client(address,portNo,isNovice));
		
		
		cp=new ClockPanel(time,this);
		textarea=new JTextArea();
		
		textarea.setCaretPosition(0);
		textarea.setEditable(false);
		textarea.setFont(new Font("SansSerif", Font.BOLD, 20));
		jsp=new JScrollPane(textarea);
			
		f.setContentPane(new JLabel(new ImageIcon(MainFrame.class.getResource("/images/bg3.jpg"))));
		
		qsp=new QuestionSummary(30,this);
		//qsp.setBorder(UIManager.getBorder("TitledBorder.border"));
		
		tp=new Timepass();
		prev=new JButton("Prev");
		next=new JButton("Next");
		submit=new JButton("Submit");
		
		cp.setBounds(30,10,180,140);
		sp.setBounds(30,220,180,130);
		
		//lifelines
		bingo=new BingoPanel(this);
		bingo.setBounds(1040,380,140,80);
		
		ff=new Fiftyfifty(this);
		ff.setBounds(1200,380,140,80);
		
		dd=new DoubleDip();
		dd.setBounds(1040,480,140,80);
		
		tp.setBounds(1200,480,140,80);
		
		jsp.setBounds(250,10,750,340);
		qsp.setBounds(1040,10,300,300);
		
		f.getContentPane().setLayout(null);
		f.getContentPane().add(jsp);
		f.getContentPane().add(cp);
		f.getContentPane().add(sp);
		f.getContentPane().add(qsp);
		f.getContentPane().add(bingo);
		f.getContentPane().add(ff);
		f.getContentPane().add(dd);
		f.getContentPane().add(tp);
		//op.showOptions();
		f.getContentPane().add(op);
		
		JButton btnPrev = new JButton("Prev");
		btnPrev.setFont(new Font("Monotype Corsiva", Font.PLAIN, 23));
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(quepos>0)
				quepos--;
				
				showQuestion((QuestionDetail) queList.get(quepos));
				
			}
		});
		btnPrev.setBounds(459, 581, 127, 40);
		f.getContentPane().add(btnPrev);
		
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Monotype Corsiva", Font.PLAIN, 23));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(quepos<(queList.size()-1))
					quepos++;
					showQuestion((QuestionDetail) queList.get(quepos));

			}
		});
		btnNext.setBounds(633, 581, 147, 40);
		f.getContentPane().add(btnNext);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Monotype Corsiva", Font.PLAIN, 26));
		btnSubmit.setBounds(1052, 598, 288, 40);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(op.selectedOption()==-1)
				{
					JOptionPane.showMessageDialog(null, "Please select an option!");
					return;
				}	
				char ans=getAns();
				if(op.checkAns(ans)){
					if(dd.isActivated()){
						sp.increaseScore(2*incrScore);
						dd.setActivated(false);
					}
					else
						sp.increaseScore(incrScore);
					if(tp.isActivated()){
						cp.setLimit(cp.getLimit()+bonus);
						tp.setActivated(false);					
					}
					isCorrect=true;
					rightQ++;
				}
				else{
					if(dd.isActivated())
						sp.decreaseScore(2*decrScore);
					else
						sp.decreaseScore(decrScore);
					if(tp.isActivated()){
						cp.setLimit(cp.getLimit()-(bonus/2));
						tp.setActivated(false);					
					}
					isCorrect=false;
					wrongQ++;
				}
				
				qsp.disableButton(((QuestionDetail)queList.get(quepos)).getQuenum(),quepos,isCorrect);
				
				attemptQ++;
				queList.remove(quepos);
				quesummary.remove(quepos);
				
				if(quepos>(queList.size()-1))
					quepos=0;
				
				if(queList.size()>0)
				showQuestion((QuestionDetail) queList.get(quepos));
				else{
					cp.setLimit(0);
				}
				//endQuiz();
				
			}
			
		});

		f.getContentPane().add(btnSubmit);
	
		f.setSize(WindowUtil.getScreenWidth(),WindowUtil.getScreenHeight());
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f.setVisible(true);
		addListenerForFrame(f);
		getQuestionsInArrayList();
	}
	
	public void addListenerForFrame(JFrame f) {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				
				int res=JOptionPane.showConfirmDialog(null, "Do you want to STOP ?");
				if(res!=1&&res!=2){
					cp.setLimit(0);
				}
			}
		});
	}

	public void endQuiz(){
		
		if(client.start()){
			client.storeScore(username,sp.getScore());
			client.stop();
		}
		f.dispose();
		FileClient.store(username, ""+sp.getScore());
		EndPanel.create(username,sp.getScore(),rightQ,wrongQ,attemptQ);
		
	}
	public char getAns() {
		
		return ((QuestionDetail)queList.get(quepos)).ans;
	}
	void getQuestionsInArrayList(){
	
		
		String path="";
		if(isNovice){
			path+="NoviceQ/";
		}
		else
			path+="ExpertQ/";
		que=new Vector<String>();
		for(int i=1;i<=50;i++)
			que.add(""+i);
		Collections.shuffle(que);
		for(int i=0;i<noofque;i++){
			
			QuestionDetail qd=new QuestionDetail();
			
			qd.readQuestion(path+que.get(i)+".txt");
			queList.add(qd);
			quesummary.add(i);
		}
		//queList=client.getQueList();
		//client.stop();
		showQuestion((QuestionDetail)queList.get(quepos));
	}
	
	
	void showQuestion(QuestionDetail qd){
		
		
		textarea.setText(qd.question);
		textarea.setCaretPosition(0);
		op.showOptions(qd.options);
		
	}
	public void showQuestion(int i){
		showQuestion((QuestionDetail) queList.get(i));
		
	}
	public static void main(String [] arfs){
	
		WindowUtil.setNimbusLook();
	
		new MainFrame("localhost","7676",30,"3",true);
		
		
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}