import java.io.BufferedReader;

import java.io.*;
public class FileReaderDemo 
{
	public static void main(String args[])
	{
		
		try 
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter no of details to store: ");
			int n=Integer.parseInt(br.readLine());
			Student[]studentDetails=new Student[n];
			System.out.println("- - - Enter student details - - - ");
			for(int i=0;i<n;i++)
			{
				System.out.println("- - - Student "+(i+1)+" details - - - ");
				System.out.print("Name : ");
				String name=br.readLine();
				System.out.print("Age :  ");
				int age=Integer.parseInt(br.readLine());
				System.out.print("Collage : ");
				String collage=br.readLine();
				studentDetails[i]=new Student(name,age,collage);
			}
			File file=new File("studentDetails.txt");
			FileWriter fw=new FileWriter(file);
			BufferedWriter bw=new BufferedWriter(fw);
			System.out.println("- - - Student details are - - -");
			for(int i=0;i<n;i++)
			{
				bw.write(studentDetails[i]+"\n");
			}
			bw.close();
			fw.close();
			FileReader fr=new FileReader(file);
			br=new BufferedReader(fr);
			String s="";
			while((s=br.readLine())!=null)
			{
				System.out.println(s);
			}
		}
		catch(Exception e) {}
	}
}
class Student
{
	private String name;
	private int age;
	private String collage;
	public Student() 
	{
		
	}
	public Student(String name,int age,String collage)
	{
		this.name=name;
		this.age=age;
		this.collage=collage;
	}
	public String toString()
	{
		return "Name:  "+name+"\tAge:  "+age+"\tCollage:  "+collage;
	}
}
