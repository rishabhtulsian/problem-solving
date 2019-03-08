import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        Map<Character, Integer> counts = new HashMap<>();
        int i = 0, j = 0;
        char[] chars = s.toCharArray();
        while(j < s.length()) {
            char c = chars[j];
            counts.put(c, counts.getOrDefault(c, 0) + 1);
            while (counts.size() >= 3) {
                c = chars[i];
                counts.put(c, counts.get(c) - 1);
                if (counts.get(c) == 0) {
                    counts.remove(c);
                }
                i++;
            }
            j++;
            max = Math.max(j-i, max);
        }
        return max;
    }
}