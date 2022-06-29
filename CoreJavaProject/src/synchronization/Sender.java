package synchronization;

public class Sender implements Runnable {
	
	private Data data;
	
	public Sender(Data data) {
		this.data = data;
	}

	@Override
	public void run() {
		synchronized (data) {
			System.out.println("sender sending data");
			data.send("test");
			
			data.notifyAll();
			
		}
		
		
		
	}
	

}
