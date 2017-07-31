/**
 * 
 */
package com.vaibhav1.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author vshukla
 * Problem Statement: 	Given an integer array and a number k, check if there exists a pair in the array whose sum is equal to given k.
 * 						For e.g. arr = {-3,2,4,-1,7} and k = 6 returns true with pair:-1 & 7 or 2,4.
 */
public class PairWithGivenSum {
	
	/**
	 * The idea is to sort the array first in increasing order. Then we take two index variables i=0 & j=arr.length-1.
	 * We check for sum of arr[i] & arr[j] while i is less than j. If it's equal to k, return true;
	 * Else if arr[i]+arr[j] < k, increment i
	 * Else decrement j.
	 * 
	 * @param arr - input array
	 * @param k - given sum
	 * @return true if pair exists
	 */
	public static boolean checkPair(int []arr, int k){
		Arrays.sort(arr);
		int i=0;
		int j=arr.length-1;
		
		while(i<j){
			int sum = arr[i]+arr[j];
			if(sum==k){
				return true;
			} else if(sum<k){
				i++;
			} else {    //sum>k
 				j--;
			}
		}
		
		return false;
	}
	
	
	/**
	 * One iteration with this problem could be to count all the pairs that sums to given k. It's easy. 
	 * 
	 * Create a map and store frequency of each integer.
	 * 
	 * In the next traversal, for each number, check if it can be combined with any other number to get the desired sum. 
	 * Increment the counter accordingly.
	 * 
	 * Every pair is counted twice in the above traversal. Return count/2 for desired count.
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	public static int countPair(int []arr, int k){
		int count = 0;
		Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
		
		//populate map
		for(int i: arr){
			if(frequency.containsKey(i)){
				int frq = frequency.get(i);
				frequency.put(i, frq+1);
			} else {
				frequency.put(i, 1);
			}
		}
		
		
		for(int i: arr){
			if(frequency.containsKey(k-i)){
				count+=frequency.get(k-i);
				
				if(k-i==i){   // satisfies the condition arr=[1,1,1,1] & k=2
					count--;
				}
			} 
		}
		return count/2;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int []arr = {6,3,-1,5,1,2};    
//		int []arr = {1,1,1,1};    
		int k=5;
		System.out.println(countPair(arr, k));

	}

}
