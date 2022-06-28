package multithreading;


class Thread1 extends Thread{
	public void run() {
		System.out.println("Thread1 is running");
		
		for(int i = 0; i<100; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println("Thread1 done");
	}
}

class Thread2 implements Runnable{
	public void run() {		
		System.out.println("Thread2 is running");
		
		for(int i = 100; i<200; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println("Thread2 done");
	}
}

class Thread3 implements Runnable{
	public void run() {		
		System.out.println("Thread3 is running");
		
		for(int i = 200; i<300; i++) {
			System.out.print(i + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Thread3 done");
	}
}
public class Thread1Runner {

	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		
		
		Thread thread2 = new Thread(new Thread2());
		
		
		Thread thread3 = new Thread(new Thread3());
		
		thread3.setPriority(Thread.MAX_PRIORITY);
		
		thread1.start();
		
		thread2.start();
		
		
		//If t is a Thread object whose thread is currently executing, then t.join() will make 
		//sure that t is terminated before the next instruction is executed by the program.
		try {
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread3.start();
		
		
		
		
		
		
		

	}

}
