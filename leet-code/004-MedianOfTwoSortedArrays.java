class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p = nums1.length;
        int q = nums2.length;
        int m1 = (p + q + 1) / 2 - 1;
        int m2 = (p + q) / 2;
        int i = 0, j = 0, k = 0, m = 0;
        while (k <= m2) {
            int x = 0;
            if (i < p) {
                if (j < q) {
                    if (nums1[i] <= nums2[j]) {
                        x = nums1[i++];
                    } else {
                        x = nums2[j++];
                    }
                } else {
                    x = nums1[i++];
                }
            } else {
                x = nums2[j++];
            }
            if (k == m1) m += x;
            if (k == m2) m += x;
            k++;
        }
        return m / 2.0;
    }
}
