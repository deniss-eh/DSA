class goru implements Runnable
{
	String name;
	Thread t;
	goru(String s , int a)
	{
		name = s;
		t=new Thread(this,name );
		System.out.println("New Thread : " + t);
		t.setPriority(a);
		t.start();  
	}
	public void run()
	{
		try
		{
			for(int i=2; i<=20; i=i+2)
			{
				System.out.println(i);
				Thread.sleep(1000);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);

		}
		System.out.println("Existing Thread " + name);
	}
}

class Multithreading 
{
	public static void main(String args[])
	{
		new goru("One" , 5);
		new goru("Two" , 10);
		new goru("Three" , 1);

		try
		{
			for(int i=10; i>=1; i--)
			{
				System.out.println("Main Thread" +" " + i);
				Thread.sleep(100);
			}
		}
		catch(Exception ew)
		{
			System.out.println(ew);
		}

	}
}