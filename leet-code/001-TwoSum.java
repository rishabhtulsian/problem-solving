import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (numMap.containsKey(other))
                return new int[] {numMap.get(other), i};
            numMap.put(nums[i], i);
        }
        return null;
    }
}