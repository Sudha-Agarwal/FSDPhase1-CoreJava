package synchronization;


class Multithread
{
	public void printCount()
	{

		try
		{
			for(int i = 5; i>=0; i--)
			{
				//Thread.sleep(1000);
				System.out.println("Counter --- " + i );
			}
		}
		catch (Exception e)
		{
			System.out.println("Thread interrupted.");
		}
	}
}

class MyThread implements Runnable
{
	private Thread t;
	private String threadName;
	Multithread MT;

	MyThread( String name, Multithread mt)
	{
		threadName = name;
		MT= mt;
	}

	@Override
	public void run()
	{
		
		synchronized(MT) {
			MT.printCount();
		}
		//MT.notifyAll();
		System.out.println("Thread " + threadName + " exiting.");
	}
	public void start ()
	{
		System.out.println("Starting " + threadName );
		
		if (t == null)
		{
			t = new Thread (this, threadName); t.start ();
		}
	}
}
public class TestThreadSynchronized {

	public static void main(String args[])
	{
		Multithread MT = new Multithread();
		MyThread t = new MyThread( "Thread - 1 ", MT);
		MyThread t1 = new MyThread( "Thread - 2 ",MT);

		//Thread t = new Thread(mt);
		//Thread t1 = new Thread(mt1);

		t.start();
		t1.start(); // wait for threads to end

		
	}

}
