class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        int n = s.length();
        boolean[][] flags = new boolean[n][n];
        int x = 0, y = 1;
        for (int i = 0; i < n - 1; i++) {
            flags[i][i] = true;
            flags[i][i+1] = s.charAt(i) == s.charAt(i+1);
            flags[i+1][i] = s.charAt(i) == s.charAt(i+1);
            if (flags[i][i+1] && y - x == 1) {
                x = i; y = i + 2;
            }
        }
        flags[n-1][n-1] = true;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                flags[j][j+i] = flags[j+1][j+i-1] && s.charAt(j) == s.charAt(j+i);
                flags[j+i][j] = flags[j][j+i];
                if (flags[j][j+i] && i + 1 > y - x) {
                    x = j; y = j + i + 1;
                }
            }
        }
        return s.substring(x, y);
    }
}