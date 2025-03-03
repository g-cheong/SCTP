/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        // Arrays.sort(nums);
        String result = String.valueOf(nums[0]);
        int swap = 0;
        for(int i = 1; i < nums.length; i++) {
            String compare = String.valueOf(nums[i]);
            if(result.charAt(result.length() - 1) < compare.charAt(0) || ) {
                swap = nums[i+1];
                nums[i+1] = nums[i];
                nums[i] = swap;
            } else {
                result += compare;
            }
            System.out.println(result);
        }
        return result;
    }
    public static void main(String[] args) {
        
    }
}
// @lc code=end

