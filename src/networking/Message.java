package networking;

import java.io.Serializable;

public class Message implements Serializable{


	private static final long serialVersionUID = 1L;
	final static int SCORE=1;
	private String username;
	private int score;
	private int type;
	private boolean isNovice;
	Message(String username,int score,int type,boolean isNovice){
		
		this.setNovice(isNovice);
		this.setUsername(username);
		this.setScore(score);
		this.setType(type);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public boolean isNovice() {
		return isNovice;
	}
	public void setNovice(boolean isNovice) {
		this.isNovice = isNovice;
	}
	
}
