class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] clone = new int[n][m];
        for (int j = 0; j < n; j++)
            for (int i = 0; i < m; i++)
                clone[j][i] = matrix[j][i];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (clone[j][i] == 0) {
                    for (int x = 0; x < m; x++)
                        matrix[j][x] = 0;
                    for (int y = 0; y < n; y++)
                        matrix[y][i] = 0;
                }
            }
        }
    }
}