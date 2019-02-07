import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, m = 0;
        for (int i = 0; i < s.length(); i++) {
            l++;
            Character c = s.charAt(i);
            Integer j = map.getOrDefault(c, null);
            if (j != null && j.intValue() >= (i - l + 1)) {
                l = i - j.intValue();
            }
            map.put(c, i);
            if (l > m) {
                m = l;
            }
        }
        return m;
    }
}