// package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

/*
2342. Max Sum of a Pair With Equal Sum of Digits
Medium

Hint
You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].

Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.

*/
class Solution2342 {
    public static int maximumSum(int[] nums) {
        HashMap<Integer, Integer> ht = new HashMap<>();
        int result = 0, highest = -1, numTotal = 0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i = nums.length - 1; i >= 0; i--){
            String numStr = String.valueOf(nums[i]);
            int numLen = numStr.length();
            numTotal = 0;
            for(int j = 0; j < numLen; j++){
                numTotal += Character.getNumericValue(numStr.charAt(j));
            }
            Integer currentNum = ht.get(numTotal);
            if(currentNum == null){
                ht.put(numTotal, i);
            } else { 
                result = nums[i] + nums[currentNum];
                if(result > highest) highest = nums[i] + nums[currentNum];
            }
        }
        System.out.println(Arrays.toString(nums));
        return highest;
    }
    public static void main(String[] args) {
        int[] case1 = {18,43,36,13,7};
        int[] case2 = {10,12,19,14};
        int[] case3 = {368,369,307,304,384,138,90,279,35,396,114,328,251,364,300,191,438,467,183};
        System.out.println(maximumSum(case1));
        System.out.println(maximumSum(case2));
        System.out.println(maximumSum(case3));
    }
}