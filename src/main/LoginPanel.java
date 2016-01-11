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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import panels.WindowUtil;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JFrame f;
	private JTextField tfUsername;
	private JPasswordField passwordField;
	private JTextField tfAdress;
	private JTextField tfPort;
	
	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		
		setLayout(new BorderLayout(0, 0));
		
		//JPanel bak = new JPanel();
		JLabel bak=new JLabel(new ImageIcon(LoginPanel.class.getResource("/images/LoginPnl.jpg")));
		bak.setBackground(Color.WHITE);
		add(bak, BorderLayout.CENTER);
		bak.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(Color.WHITE);
		panel.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel.setBounds(143, 153, 491, 297);
		bak.add(panel);
		panel.setLayout(null);
		
		int w=100;
		
		JLabel lblUsername = new JLabel("Username ");
		lblUsername.setBounds(w, 30+20, 150, 38);
		panel.add(lblUsername);
		lblUsername.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		
		tfUsername = new JTextField();
		tfUsername.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		tfUsername.setBounds(w+170, 57, 152, 40);
		panel.add(tfUsername);
		tfUsername.setColumns(10);
		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(w, 80+50, 150, 38);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		passwordField.setBounds(w+170, 87+50, 152, 40);
		panel.add(passwordField);
		
		JButton btnNoviceLogin = new JButton("Login as Novice");
		btnNoviceLogin.setBounds(43+10, 220, 197, 43);
		panel.add(btnNoviceLogin);
		btnNoviceLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(checkValidUser(true)){
				
					InstructionPanel.create(tfAdress.getText().trim(),tfPort.getText(),tfUsername.getText(), true);
					f.dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "Username/Password is incorrect");
			}

			
		});
		btnNoviceLogin.setFont(new Font("Monotype Corsiva", Font.BOLD, 25));
		
		JButton btnLoginAsExpert = new JButton("Login as Expert");
		btnLoginAsExpert.setBounds(266+10, 220, 197, 43);
		panel.add(btnLoginAsExpert);
		btnLoginAsExpert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkValidUser(false)){
					InstructionPanel.create(tfAdress.getText().trim(),tfPort.getText(),tfUsername.getText(), false);
					f.dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "Username/Password is incorrect");
			}
		});
		btnLoginAsExpert.setFont(new Font("Monotype Corsiva", Font.BOLD, 25));
		
		JLabel lblServeraddress = new JLabel("ServerAddress:");
		lblServeraddress.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblServeraddress.setBounds(44, 525, 156, 30);
		bak.add(lblServeraddress);
		
		tfAdress = new JTextField("sujata-pc");
		tfAdress.setBounds(203, 529, 149, 32);
		tfAdress.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		bak.add(tfAdress);
		tfAdress.setColumns(10);
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblPort.setBounds(364, 525, 65, 30);
		bak.add(lblPort);
		
		tfPort = new JTextField("7040");
		tfPort.setColumns(10);
		tfPort.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		tfPort.setBounds(420, 529, 149, 32);
		bak.add(tfPort);
		setSize(800,600);

	}
	public boolean checkValidUser(boolean isNovice) {
		
		
		boolean b=false;
		String username=tfUsername.getText();
		String pass=new String(passwordField.getPassword());
		System.out.println("*"+username+"*"+pass+"*");
		if(username.equals(pass))
		{	
			System.out.println("matched");
			if(isNovice){
				if(username.contains("#Novice")){
					b=true;
				}
			}
			else if(username.contains("#Expert")){
				System.out.println("expert");
				b=true;
			}
					
				
		}
		return b;
		
		
	}
	public static void main(String[] args) {
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		create();
	}

	public static void create() {
		
		WindowUtil.setNimbusLook();
		
		f=new JFrame("Login");
		f.setResizable(false);
		f.getContentPane().add(new LoginPanel());
		WindowUtil.setToCenter(f, 800, 620);
		f.setVisible(true);
		
	}
}
