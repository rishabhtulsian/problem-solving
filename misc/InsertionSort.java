import java.util.Arrays;

public class InsertionSort {
	public int[] sort(int[] nums) {
		for(int i = 1; i < nums.length; i++) {
			int next = nums[i];
			int j = i;
			for(; j > 0 && nums[j-1] > next; j--) {
				nums[j] = nums[j-1];
			}
			nums[j] = next;
		}
		return nums;
	}

	public static void main(String[] args) {
		InsertionSort sorter = new InsertionSort();
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
