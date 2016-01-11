package main;
import java.io.*;
public class FileClient {

	public static void store(String un,String score){
		
		File file=new File("score.txt");
		FileWriter fw=null;
		BufferedWriter bw=null;
		
		try {
			fw=new FileWriter(file.getAbsoluteFile(),true);
	         bw=new BufferedWriter(fw);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		try {
				bw.write("\r\n");
				bw.write(un);
				bw.write("====> ");
				bw.write(score);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public static void main(String[] args) {
		
		store("piyush",""+25);
	
	}

}
