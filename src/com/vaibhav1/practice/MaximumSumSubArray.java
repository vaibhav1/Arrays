/**
 * 
 */
package com.vaibhav1.practice;

/**
 * @author vshukla
 * Problem Statement: Given an array of integers, return the maximum sum in contiguous sub array.
 * For Example: 1. arr = {6,-3, -10, 0, 2} maximum sum is : 6
 * 				2. arr = {1, 2, 3, 4} maximum sum is : 10
 * 				3. arr = {-2, -3, 4, -1, -2, 1, 5, -3} maximum sum is : 7
 * 				4. arr = {-2,-1,-5,-3,-9,-6} maximum sum is -1
 */
public class MaximumSumSubArray {
	
	
	/**
	 * Idea is to use Kadane's algorithm. We look for all positive contiguous segments of array using curr_max
	 * and keep track of maximum contiguous segment using max_so_far. Update max_so_far is curr_max is greater than max_so_far.
	 * 
	 * @param a - the input array
	 * @return - max sum of subarray
	 */
	public static int maxSubArraySum(int a[]) {
		int max_so_far = a[0];
		int curr_max = a[0];

		for (int i = 1; i < a.length; i++) {
			curr_max = Math.max(a[i], curr_max + a[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int []arr1 = {6,-3, -10, 0, 2};
		int []arr2 = {1, 2, 3, 4};
		int []arr3 = {-2, -3, 4, -1, -2, 1, 5, -3};
		int []arr4 = {-2,-1,-5,-3,-9,-6};
		
		int maxSum1 = maxSubArraySum(arr1);
		int maxSum2 = maxSubArraySum(arr2);
		int maxSum3 = maxSubArraySum(arr3);
		int maxSum4 = maxSubArraySum(arr4);
		
		System.out.println(maxSum1);
		System.out.println(maxSum2);
		System.out.println(maxSum3);
		System.out.println(maxSum4);

	}

}
