/**
 * 
 */
package com.vaibhav1.practice;

/**
 * @author vshukla
 * Problem statement: Given an array of N+2 positive integers in range 1...N . Find the two duplicates in array.
 */
public class FindDuplicateInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []a = {4, 2, 4, 5, 2, 3, 1};
		findDuplicates(a);

	}

	/**
	 * The idea is very simple. Since the range of elements is given, we create an auxiliary array count to keep the count of each element.
	 * Traverse the array and set the count for each element visited. If the count is already set, the current element is duplicate. Print that.
	 * @param a - given input array.
	 */
	private static void findDuplicates(int[] a) {
		int []count = new int[a.length];
		
		//initialize count to 0
		int i=0;
		System.out.println("Duplicates are:");
		for(i=0;i<a.length;i++){
			if(count[a[i]]==1){
				System.out.print(a[i]+",");
				
			}else{
				count[a[i]]++;
			}
		}
		
	}

}
