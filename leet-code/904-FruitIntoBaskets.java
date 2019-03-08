class Solution {
    public static int totalFruit(int[] tree) {
        int max = 0;
        for (int i = 0; i < tree.length; i++) {
            int t1 = -1;
            int t2 = -1;
            int count = 0;
            for (int j = i; j < tree.length - max; j++) {
                if (t1 == tree[j] || t2 == tree[j]) {
                    count++;
                } else if (t1 == -1) {
                    t1 = tree[j];
                    count++;
                } else if (t2 == -1) {
                    t2 = tree[j];
                    count++;
                } else {
                    if (count > max) {
                        max = count;
                    }
                    break;
                }
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}