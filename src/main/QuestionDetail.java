package main;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Vector;
public class QuestionDetail {
	String question;
	String [] options;
	char ans;
	private int quenum;
	int ansSelected;
	public int getQuenum() {
		return quenum;
	}
	public void setQuenum(int quenum) {
		this.quenum = quenum;
	}
	static int queNo;
	QuestionDetail(){
		
		question =new String();
		options =new String[4];
		ans='a';
		ansSelected=0;
		quenum=queNo;
		queNo++;
	}
	public void readQuestion(String filename){
		
		
		BufferedReader br=null;
		try
		{
			InputStream in = getClass().getResourceAsStream("/"+filename);
			//br=new BufferedReader(new InputStreamReader(new FileInputStream(QuestionDetail.class.getResource("/"+filename).toString().substring(6))));
			br=new BufferedReader(new InputStreamReader(in));
		}
		catch(Exception e){
			System.out.println(e);
		}
		try
		{
			String tmpans=br.readLine().trim();
			Vector<String> v=new Vector<String>();
			for(int i=0;i<4;i++){
				
				
				options[i]=br.readLine();
				options[i]=options[i].trim();
				v.add(options[i]);
				
			}
			Collections.shuffle(v);
			for(int i=0;i<4;i++){
				options[i]=v.get(i);
				if(options[i].equals(tmpans)){
					ans=(char) ('A'+i);
				}
			}
			String str="";
			
			question=queNo+".";
			while((str=br.readLine())!=null){
			
				if(str.length()>0)
				question+=str+"\n";
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
