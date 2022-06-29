package multiThreading;

class Thread1 extends Thread{

	public void run() {
		System.out.println("Thread1 is running");

		for(int i=0; i< 100; i++) {
			System.out.print(i + " ");
		}
		System.out.println("Thread1 is done");

	}

}

class Thread2 implements Runnable{
	public void run() {
		System.out.println("Thread2 is running");

		for(int i=100; i< 200; i++) {
			System.out.print(i + " ");
		}
		System.out.println("Thread2 is done");
	}
}

class Thread3 implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread3 is running");

		for(int i=200; i< 300; i++) {
			System.out.print(i + " ");
		}
		System.out.println("Thread3 is done");


	}

}


public class ThreadRunner {

	public static void main(String[] args) {

		Thread1 thread1 = new Thread1();

		Thread2 t2 = new Thread2();

		Thread thread2 = new Thread(t2);
		
		Thread thread3 = new Thread(new Thread3());
		
		thread3.setPriority(Thread.MAX_PRIORITY);

		thread1.start();
		thread2.start();
		
		/*try {
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		thread3.start();
		
		//thread3.interrupt();





	}

}
