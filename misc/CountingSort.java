import java.util.Arrays;

public class CountingSort {
	public int[] sort(int[] nums, int k1, int k2) {
		int n = k2-k1+1;
		int[] C = new int[n];
		for(int i = 0; i < n; i++) {
			C[i] = 0;
		}
		for(int i = 0; i < nums.length; i++) {
			// C[nums[i] - k1] = C[nums[i] - k1] + 1;
			C[nums[i] - k1]++;
		}
		for(int i = 1; i < n; i++) {
			C[i] = C[i] + C[i-1];
		}
		int[] sorted = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			sorted[C[nums[i] - k1]-1] = nums[i];
			C[nums[i] - k1]--;
		}
		return sorted;
	}

	public static void main(String[] args) {
		CountingSort sorter = new CountingSort();
		int[] unsorted = new int[] {22, 10, 9, 33, 50, 0, -1, 20, 22, -9, 80, 70, 60};
		int[] sorted = sorter.sort(unsorted, -10, 100);
		System.out.println(Arrays.toString(sorted));

		int items = 10000000;
		int[] bigArray = new int[items];
		for(int i = 0; i < items; i++) {
			bigArray[i] = items - i;
		}
		long startTime = System.nanoTime();
		bigArray = sorter.sort(bigArray, 1, items);
		for(int i = 0; i < items; i++) {
			if(bigArray[i] != i+1) {
				System.out.println("Invalid sort");
				break;
			}
		}
		System.out.println("bigArray("+ items +"): time " + (System.nanoTime() - startTime) / 1000000000.0 + " sec");
	}
}
