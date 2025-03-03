package Leetcode;
/*
 * @lc app=leetcode id=3066 lang=java
 *
 * [3066] Minimum Operations to Exceed Threshold Value II
 */
import java.util.PriorityQueue;

// @lc code=start
class Solution {
    public int minOperations(int[] nums, int k) {
        int result = 0;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++){
            minHeap.add((long)nums[i]);
        }
        while(minHeap.peek() < k) {
            long first = minHeap.poll();
            long second = minHeap.poll();
            minHeap.add(Math.min(first, second) * 2 + Math.max(first,second));
            result++;
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] case1 = {2,11,10,1,3};
        int[] case2 = {1000000000,999999999,1000000000,999999999,1000000000,999999999};
        System.out.println(solution.minOperations(case1,10));
        System.out.println(solution.minOperations(case2,1000000000));
    }
}
// @lc code=end

