package file;
import java.io.*;
public class FileMethods {
	
	public static void main(String args[]) throws IOException
	{
		File file=new File("kow.txt");
		System.out.println(file.exists());
		System.out.println(file.exists());
		System.out.println(file.exists());
//		file.createNewFile();
//		System.out.println(file.exists());
		System.out.println(file.exists());
		FileWriter fw=new FileWriter(file);
		System.out.println(file.exists());
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write("kowlutla"+"\n");
		bw.close();
		fw.close();
	}

}
