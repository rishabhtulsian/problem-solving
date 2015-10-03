import java.util.Arrays;

public class HeapSort {
	public int[] sort(int[] nums) {
		buildMaxHeap(nums);
		for(int i = nums.length - 1; i > 0; i--) {
			int temp = nums[0];
			nums[0] = nums[i];
			nums[i] = temp;
			maxHeapify(nums, 0, i);
		}
		return nums;
	}

	private void buildMaxHeap(int[] nums) {
		for(int i = nums.length/2; i >=0; i--) {
			maxHeapify(nums, i, nums.length);
		}
	}

	private void maxHeapify(int[] nums, int i, int heapSize) {
		int largest = i;
		if((2*i+1) < heapSize && nums[2*i+1] > nums[largest]) {
			largest = 2*i+1;
		}
		if((2*i+2) < heapSize && nums[2*i+2] > nums[largest]) {
			largest = 2*i+2;
		}
		if(largest != i) {
			int temp = nums[i];
			nums[i] = nums[largest];
			nums[largest] = temp;
			maxHeapify(nums, largest, heapSize);
		}
	}

	public static void main(String[] args) {
		HeapSort sorter = new HeapSort();
		int[] unsorted = new int[] {22, 10, 9, 33, 50, 0, -1, 20, 22, -9, 80, 70, 60};
		int[] sorted = sorter.sort(unsorted);
		System.out.println(Arrays.toString(sorted));

		int items = 10000000;
		int[] bigArray = new int[items];
		for(int i = 0; i < items; i++) {
			bigArray[i] = items - i;
		}
		long startTime = System.nanoTime();
		bigArray = sorter.sort(bigArray);
		for(int i = 0; i < items; i++) {
			if(bigArray[i] != i+1) {
				System.out.println("Invalid sort");
				break;
			}
		}
		System.out.println("bigArray("+ items +"): time " + (System.nanoTime() - startTime) / 1000000000.0 + " sec");
	}
}
