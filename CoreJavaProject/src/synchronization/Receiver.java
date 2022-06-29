package synchronization;

public class Receiver implements Runnable{
	
	private Data data;
	private String message;
	
	public Receiver(Data data) {
		this.data = data;
	}

	@Override
	public void run() {
		synchronized (data) {
			try {
				data.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("receiver receiving data");
			this.message = data.receive();
			System.out.println(this.message);
			
		}
		
		
	}
	
	

}
