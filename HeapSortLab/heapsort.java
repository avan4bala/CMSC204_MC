
/**
 * @author avanbala
 *
 */

public class heapsort {

	public static void main(String[] args) {
		int[] heap = {5,22,9,76,63,81,48,92,54,28};
        int index = heap.length/2-1;

		heapthenum(heap,index,heap.length);
		sort(heap,heap.length-1);

	}

	private static void sort(int[] heap, int length) {
		if(length == 0)
			return;

		int temp = heap[length];
		heap[length] = heap[0];
		heap[0] = temp;
		for(int i: heap)
			System.out.print(i+"  ");
		System.out.println();
		int index = (length)/2-1;
		heapthenum(heap,index, length);
		
		sort(heap,length-1);
	}


	public static void heapthenum(int[] heap, int index, int maxSize) {

		if(index == -1)
			return;
		swapM(heap,index, maxSize);
		for(int i: heap)
			System.out.print(i+"  ");
		System.out.println();
		heapthenum(heap,index-1, maxSize);
	}

	public static void swapM(int[] heap, int index, int maxSize) {
		if(index>maxSize)
			return;

		int x = 0;
		if(index*2+2>=maxSize) {
			if(index*2+1>=maxSize)
				return;
			else
				x = heap[index*2+1];
		}
		else
			x = Math.max(heap[index*2+1], heap[index*2+2]);

		int y = 0;
		if(x == heap[index*2+1]) {
			y = index*2+1;
		}
		else 
			y = index*2+2;

		if(heap[index]<heap[y]) {
			int temp = heap[index];
			heap[index] = heap[y];
			heap[y] = temp;
			if(y*2+1<maxSize)
				swapM(heap,y, maxSize);
		}
	}


}
