class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int pos1 = (nums1.size() + nums2.size() + 1) / 2 - 1;
        int pos2 = (nums1.size() + nums2.size()) / 2;
        int i = 0, j = 0, k = 0;
        int m1 = -1, m2 = -1;
        while((i < nums1.size() || j < nums2.size()) && k <= pos2) {
            int m = -1;
            if(i < nums1.size() && j < nums2.size()) {
                if(nums1[i] <= nums2[j]) {
                    m = nums1[i];
                    i++;
                } else {
                    m = nums2[j];
                    j++;
                }
            } else if(i < nums1.size()) {
                m = nums1[i];
                i++;
            } else {
                m = nums2[j];
                j++;
            }
            if(k == pos1) {
                m1 = m;
            }
            if(k == pos2) {
                m2 = m;
            }
            k++;
        }
        return m1 + (m2-m1)/2.0;
    }
};
