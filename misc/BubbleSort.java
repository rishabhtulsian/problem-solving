import java.util.Arrays;

public class BubbleSort {
	public int[] sort(int[] nums) {
		for(int i = 0; i < nums.length - 1; i++) {
			for(int j = 0; j < nums.length - 1 - i; j++) {
				if(nums[j] > nums[j+1]) {
					int swap = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = swap;
				}
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		BubbleSort sorter = new BubbleSort();
		int[] unsorted = new int[] {22, 10, 9, 33, 50, 0, -1, 20, 22, -9, 80, 70, 60};
		int[] sorted = sorter.sort(unsorted);
		System.out.println(Arrays.toString(sorted));

		int items = 100000;
		int[] bigArray = new int[items];
		for(int i = 0; i < items; i++) {
			bigArray[i] = items - i;
		}
		long startTime = System.nanoTime();
		sorter.sort(bigArray);
		System.out.println("bigArray("+ items +"): time " + (System.nanoTime() - startTime) / 1000000000.0 + " sec");
	}
}
