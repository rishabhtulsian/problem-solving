import java.util.Arrays;

public class QuickSortIterative {
	public int[] sort(int[] nums, int p, int r) {
		int[] stack = new int[r-p+1];
		int top = -1;
		stack[++top] = p;
		stack[++top] = r;
		while (top >= 0) {
			r = stack[top--];
			p = stack[top--];
			int q = partition(nums, p, r);
			if(p < q-1) {
				stack[++top] = p;
				stack[++top] = q-1;
			}
			if(q+1 < r) {
				stack[++top] = q+1;
				stack[++top] = r;
			}
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
		QuickSortIterative sorter = new QuickSortIterative();
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
