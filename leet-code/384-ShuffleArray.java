import java.util.Random;

class Solution {
    private int[] nums;
    private Random generator;

    public Solution(int[] nums) {
        this.nums = nums;
        this.generator = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;        
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffled = this.nums.clone();
        for (int i = 0; i < shuffled.length; i++) {
            int idx = this.generator.nextInt(shuffled.length - i);
            int temp = shuffled[i];
            shuffled[i] = shuffled[idx+i];
            shuffled[idx+i] = temp;
        }
        return shuffled;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */