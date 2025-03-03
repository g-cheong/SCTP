/*
 * @lc app=leetcode id=1352 lang=java
 *
 * [1352] Product of the Last K Numbers
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

class ProductOfNumbers {
    private ArrayList<Integer> arr;
    private int count;
    public ProductOfNumbers() {
        arr = new ArrayList<>();
        count = 0;
    }
    
    public void add(int num) {
        arr.add(num);
        count++;
    }
    
    public int getProduct(int k) {
        int product = 1;
        System.out.println("k is " +  k);
        for(int i = count - 1; i >= count - k; i--){
            product *= arr.get(i);
            System.out.println(product);
        }
        return product;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
// @lc code=end

