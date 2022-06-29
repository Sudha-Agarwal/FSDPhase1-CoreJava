package synchronization;

public class SenderReceiverRunner {

	public static void main(String[] args) {
		
		Data data = new Data();
		
		Receiver receiver = new Receiver(data);
		Thread receiverThread = new Thread(receiver);
		receiverThread.start();
		
		Sender sender = new Sender(data);
		
		Thread senderThread = new Thread(sender);
		senderThread.start();
		
		
			

	}

}
