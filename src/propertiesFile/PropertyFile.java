package propertiesFile;

import java.io.*;
import java.util.*;

public class PropertyFile {

	public static void main(String[] args) throws IOException {
		
		Properties p=new Properties();
		OutputStream os=new FileOutputStream("config.properties");
		p.setProperty("User", "Kowlutla");
		p.setProperty("Password", "kowludeepu");
		p.store(os,null);
		
		FileInputStream fis=new FileInputStream("config.properties");
		p.load(fis);
		System.out.println("UserName: "+p.getProperty("User"));
		System.out.println("PassWord: "+p.getProperty("Password"));

	}

}
