import java.util.Arrays;

public class QuickSortRecursive {
	public int[] sort(int[] nums, int p, int r) {
		if(p < r) {
			int q = partition(nums, p, r);
			sort(nums, p, q-1);
			sort(nums, q+1, r);
		}
		return nums;
	}

	private int partition(int[] nums, int p, int r) {
		int pivot = nums[r];
		int i = p, temp;
		for(int j = p; j < r; j++) {
			if(nums[j] <= pivot) {
				temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
			}
		}
		temp = nums[i];
		nums[i] = nums[r];
		nums[r] = temp;
		return i;
	}

	public static void main(String[] args) {
		QuickSortRecursive sorter = new QuickSortRecursive();
		int[] unsorted = new int[] {22, 10, 9, 33, 50, 0, -1, 20, 22, -9, 80, 70, 60};
		int[] sorted = sorter.sort(unsorted, 0, unsorted.length-1);
		System.out.println(Arrays.toString(sorted));

		int items = 100000;
		int[] bigArray = new int[items];
		for(int i = 0; i < items; i++) {
			bigArray[i] = items - i;
		}
		long startTime = System.nanoTime();
		bigArray = sorter.sort(bigArray, 0, bigArray.length-1);
		for(int i = 0; i < items; i++) {
			if(bigArray[i] != i+1) {
				System.out.println("Invalid sort");
				break;
			}
		}
		System.out.println("bigArray("+ items +"): time " + (System.nanoTime() - startTime) / 1000000000.0 + " sec");
	}
}
