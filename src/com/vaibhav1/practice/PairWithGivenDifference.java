/**
 * 
 */
package com.vaibhav1.practice;

import java.util.Arrays;

/**
 * @author vshukla
 * Problem Statement: Given an integer array and a number diff, check if there exists a pair in the array whose difference is equal to given diff.
 * 					For e.g. arr = {-3,2,4,-1,7} and k = 8 returns true with pair:-1 & 7. False otherwise
 * 									{-3,-1,2,4,7}
 * 					
 */
public class PairWithGivenDifference {
	
	
	public static boolean checkPair(int []arr, int diff){
		Arrays.sort(arr);
		
		int i=0;
		int j=1;
		
		int len = arr.length;
		while(i<len && j<len){
			
			if(i!=j && arr[j]-arr[i]==diff){
				return true;
			} else if(arr[j]-arr[i]<diff){
				j++;
			} else{
				i++;
			}
		}
		
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int []arr = {-3,2,4,-1,7};
		int diff = 8;
		System.out.println(checkPair(arr, diff));

	}

}
