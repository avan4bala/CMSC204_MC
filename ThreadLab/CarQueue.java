/**
 * 
 */

/**
 * @author avanbala
 *
 */

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;


public class CarQueue {
	Random direction;
	Queue<Integer> queue;
	public CarQueue() {
		direction=new Random();
		queue=new ArrayDeque<Integer>();
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
	}
	public int deleteQueue() {
		int randomNum;
		randomNum=queue.remove();
		return randomNum;
		
	}
	public void addToQueue() {
		class Run implements Runnable{
			@Override
			public void run() {
				try {
					while (true) {
						queue.add(direction.nextInt(4));
						Thread.sleep(100);
					}
					
				} catch (InterruptedException element) {
					element.printStackTrace();
				}
				
			}
		}
		Run run=new Run();
		Thread runThread=new Thread(run);
		runThread.start();
	}
}
