class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("-", "").toUpperCase();
        StringBuilder F = new StringBuilder();
        int first = S.length() % K;
        if (first > 0) {
            F.append(S.substring(0, first));
        }
        for (int i = first; i <= S.length() - K; i += K) {
            if (i > 0) {
                F.append("-");
            }
            F.append(S.substring(i, i + K));
        }
        return F.toString();
    }
}