package synchronization;

class BiCounter {
	private int i = 0;
	private int j = 0;
	
	synchronized public void incrementI() {
		i++; 
		//get i
		//increment  
		//set i
	}

	public int getI() {
		return i;
	}
	
	synchronized public void incrementJ() {
		j++; 
		//get j
		//increment  
		//set j
	}

	public int getJ() {
		return j;
	}

}

public class BiCounterRunner{
	public static void main(String[] args) {
		BiCounter obj = new BiCounter();
		
		
	
		obj.incrementI();
		obj.incrementJ();
		System.out.println(obj.getI());
		
	}
}


