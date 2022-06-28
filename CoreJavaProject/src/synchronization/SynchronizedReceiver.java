package synchronization;

class SynchronizedReceiver implements Runnable {
    
    private final Data data;
    private String message;

    public SynchronizedReceiver(Data data) {
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
			System.out.println("receiver receving data");
			this.message = data.receive();
            System.out.println(this.getMessage());
        }
    }

    public String getMessage() {
        return message;
    }
}