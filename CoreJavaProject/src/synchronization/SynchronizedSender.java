package synchronization;

class SynchronizedSender implements Runnable {
    private final Data data;



    public SynchronizedSender(Data data) {
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
