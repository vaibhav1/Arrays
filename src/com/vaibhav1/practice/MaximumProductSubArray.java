/**
 * 
 */
package com.vaibhav1.practice;

/**
 * @author vshukla
 * Problem statement:  Given an array of integers, return the maximum product in a contiguous subarray.
 * For Example: 1. arr = {6,-3, -10, 0, 2} maximum product is : 180
 * 				2. arr = {-1, 2, -3, -4} maximum product is : 12
 */
public class MaximumProductSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] array = {1, -2, -3, 0, 7, -8, -2};
		
		int maxProduct = findMaximumProductSubArray(array);
		
		System.out.println("Maximum product is: "+maxProduct);

	}

	/**
	 * @param arr
	 * In this problem, the sign of a number impacts the result. So we need to take care of it.
	 * The idea is to track minimum value so if the negative number is encountered, it can have maximum value.
	 * We have two arrays to track min and max.
	 */
	private static int findMaximumProductSubArray(int[] arr) {
		int []max = new int[arr.length];
		int []min = new int[arr.length];
		
		max[0] = min[0] = arr[0];
		
		int result = arr[0];
		 
	    for(int i=1; i<arr.length; i++){
	        if(arr[i]>0){
	            max[i]=Math.max(arr[i], max[i-1]*arr[i]);
	            min[i]=Math.min(arr[i], min[i-1]*arr[i]);
	        }else{
	            max[i]=Math.max(arr[i], min[i-1]*arr[i]);
	            min[i]=Math.min(arr[i], max[i-1]*arr[i]);
	        }
	 
	        result = Math.max(result, max[i]);
	    }

	    return result;
	}

}
