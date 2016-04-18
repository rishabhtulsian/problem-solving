import java.util.Arrays;

public class MergeSortIterative {
	public int[] sort(int[] nums, int p, int r) {
		for(int size = 1; size <= r-p+1; size *= 2) {
			for(int i = p; i <= r-1; i += size * 2) {
				int mid = Math.min(i + size - 1, r);
				int end = Math.min(i + size * 2 - 1, r);
				merge(nums, i, mid, end);
			}
		}
		return nums;
	}

	private void merge(int[] nums, int p, int q, int r) {
		int n1 = q-p+1, n2 = r-q;
		int[] L = new int[n1];
		int[] R = new int[n2];

		for(int x = p; x <= q; x++) {
			L[x-p] = nums[x];
		}
		for(int x = q+1; x <= r; x++) {
			R[x-q-1] = nums[x];
		}

		int i = 0, j = 0, k = 0;
		while(i < n1 || j < n2) {
			if(i < n1 && j < n2) {
				if(L[i] <= R[j]) {
					nums[p+k] = L[i];
					i++;
				} else {
					nums[p+k] = R[j];
					j++;
				}
			} else if(i < n1) {
				nums[p+k] = L[i];
				i++;
			} else {
				nums[p+k] = R[j];
				j++;
			}
			k++;
		}
	}

	public static void main(String[] args) {
		MergeSortIterative sorter = new MergeSortIterative();
		int[] unsorted = new int[] {22, 10, 9, 33, 50, 0, -1, 20, 22, -9, 80, 70, 60};
		int[] sorted = sorter.sort(unsorted, 0, unsorted.length-1);
		System.out.println(Arrays.toString(sorted));

		int items = 10000000;
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
