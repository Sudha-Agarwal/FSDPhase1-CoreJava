package synchronization;

public class SenderReceiverRunner {
	public static void main(String[] args) {
		Data data = new Data();

		SynchronizedReceiver receiver = new SynchronizedReceiver(data);
	    Thread receiverThread = new Thread(receiver, "receiver-thread");
	    receiverThread.start();

	    SynchronizedSender sender = new SynchronizedSender(data);
	    Thread senderThread = new Thread(sender, "sender-thread");
	    senderThread.start();

	    try {
			senderThread.join(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			receiverThread.join(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
