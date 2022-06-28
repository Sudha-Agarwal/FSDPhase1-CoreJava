package waitAndNotify;

public class Thread1
{
	public static void main(String[] args)
	{
		Thread2 b = new Thread2();
		b.start();
		synchronized(b)
		{
			System.out.println("Waiting for 2 to complete...");
			try {
				b.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Total is: " + b.total);
		} } }


class Thread2 extends Thread
{
	int total;
	@Override 
	public void run()
	{
		synchronized(this)
		{
			for(int i=0; i<=100 ; i++)
			{
				total += i;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.print(" i: " + i + " " + " total: " + total);
			}
			notify();
		}}}
