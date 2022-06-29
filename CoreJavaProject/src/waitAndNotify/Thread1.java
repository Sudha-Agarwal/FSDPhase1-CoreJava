package waitAndNotify;

public class Thread1 {
	public static void main(String[] args) {

		Thread2 thread2= new Thread2();
		thread2.start();

		
		synchronized(thread2) {
			System.out.println("Waiting for thread2 to complete");
			try {
				thread2.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Total is: " + thread2.total);		

		}

	}

}

class Thread2 extends Thread{
	int total;


	public void run() {
		synchronized(this) {
			for(int i=0; i<=100; i++) {
				total+= i;			
			}

			//notify();

			//System.out.println("Total: " + total);
		}
	}
}
