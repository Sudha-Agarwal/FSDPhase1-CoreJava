package synchronization;


class MyThreadNonSynchronized implements Runnable
{
	private Thread t;
	private String threadName;
	Multithread MT;

	MyThreadNonSynchronized( String name, Multithread mt)
	{
		threadName = name;
		MT= mt;
	}

	@Override
	public void run()
	{
		MT.printCount();
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


public class TestThreadWithoutSynchronization {
	public static void main(String args[])
	{
		Multithread MT = new Multithread();
		MyThreadNonSynchronized t = new MyThreadNonSynchronized( "Thread - 1 ", MT);
		MyThreadNonSynchronized t1 = new MyThreadNonSynchronized( "Thread - 2 ",MT);

		//Thread t = new Thread(mt);
		//Thread t1 = new Thread(mt1);

		t.start();
		t1.start(); // wait for threads to end


	}


}
