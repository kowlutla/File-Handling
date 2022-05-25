import java.io.*;
public class ProducerConsumer 
{
	public static void main(String args[])
	{
		ItemClass itemclass=new ItemClass();
		new Producer(itemclass);
		new Consumer(itemclass);
	}
}
class ItemClass
{
	int item;
	boolean valueSet=false;
	public synchronized void put(int item)
	{
		while(valueSet)
		{
			try {wait();}catch(Exception e) {}
		}
		System.out.println("Put Item "+item);
		this.item=item;
		valueSet=true;
		notify();
	}
	public synchronized void get()
	{
		while(!valueSet)
		{
			try {wait();}catch(Exception e){}
		}
		System.out.println("Get Item "+item);
		valueSet=false;
		notify();
	}
}
class Producer implements Runnable
{
	ItemClass itemclass;
	public Producer(ItemClass itemclass)
	{
		this.itemclass=itemclass;
		Thread t=new Thread(this,"Producer");
		t.start();
	}
	public void run()
	{
		int i=1;
		while(i<=10)
		{
			itemclass.put(i++);
			try {Thread.sleep(3000);}catch(Exception e) {}
		}
	}
}
class Consumer implements Runnable
{
	ItemClass itemclass;
	public Consumer(ItemClass itemclass)
	{
		this.itemclass=itemclass;
		Thread t=new Thread(this,"Consumer");
		t.start();
	}
	public void run()
	{
		while(true)
		{
			itemclass.get();
			try {Thread.sleep(2000);}catch(Exception e) {}
		}
	}
}




