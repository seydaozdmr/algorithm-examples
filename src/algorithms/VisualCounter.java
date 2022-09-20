package algorithms;

public class VisualCounter {
	
	private int n;
	private int max;
	
	private int totalOperations;
	private int counter;
	
	public VisualCounter(int n,int max) {
		this.n=n;
		this.max=Math.abs(max);
		
		StdDraw.setCanvasSize(1024, 512);
		StdDraw.setPenRadius(.015);
		StdDraw.setXscale(0, n+1);
        StdDraw.setYscale(-max-3, max+3);	
	}
	
	private void increment() {
		if(totalOperations<n && counter<max) {
			totalOperations++;
			counter++;
			
			plotCounter();
		}
	}
	
	private void decrement() {
		if(totalOperations<n && Math.abs(counter)<max || counter==max) {
			totalOperations++;
			counter--;
			plotCounter();
		}
	}
	
	

	private void plotCounter() {
		StdDraw.point(totalOperations, counter);
		
	}

	public static void main(String[] args) {
		VisualCounter vc=new VisualCounter(4, 2);
		
		vc.increment();
		vc.decrement();
		vc.decrement();
		vc.decrement();
		vc.decrement();
		vc.increment();
		vc.increment();
		vc.decrement();
		vc.decrement();
		vc.decrement();
		vc.decrement();
		vc.increment();

	}

}
