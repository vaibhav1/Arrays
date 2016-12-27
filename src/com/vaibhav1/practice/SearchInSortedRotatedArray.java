/**
 * 
 */
package com.vaibhav1.practice;

/**
 * @author vshukla
 *
 *         Problem Statement: Given a sorted integer array which is rotated at
 *         one point, called pivot. Search a given key effectively. Assume there
 *         are no duplicates. For e.g. : int []arr = {4,5,6,7,0,1,2} is rotated
 *         at 7. Key = 5. Method should return 1 as the index to 5
 */
public class SearchInSortedRotatedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = { 4, 5, 6, 0, 1, 2 };
		System.out.println(search(a, 0));
	}

	/**
	 * The idea is to implement a classic binary search but with a little twist.
	 * 
	 * 1.Check for the rotation point or the pivot element. If its out of range
	 * i.e pivot<low or pivot>high then array is sorted entirely. Use binary
	 * search
	 * 
	 * 2. 	If rotation point is in range [low, mid). 
	 * 	  	In this case, target < A[mid] is not sufficient to tell us to move the left half. 
	 * 	  	Instead, only if a[low] <= target < a[mid], move to the left half; otherwise, move to the right half.
	 * 
	 * 3. 	If rotation point is in range (mid, high]. 
	 * 		In this case, target > a[mid] is not sufficient to tell us to move right half.
	 * 		Instead, only if a[mid]<target <=a[high], move right;otherwise move left.
	 * 		
	 * 
	 * @param a - input array
	 * @param key - target value to search
	 * @return index of the key if present, else -1
	 */
	public static int search(int[] a, int key) {

		int low = 0;
		int high = a.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (a[mid] == key) {
				return mid;
			}

			if (
					(a[low] < a[high] && a[mid] < key)
					
					// rotate point is in [low..mid)
					|| (a[mid] < a[high] && key > a[mid] && key >= a[high])
					
					// rotate point is in (mid..high]
					|| (a[mid] > a[high] && (key > a[mid] || key <= a[high]))) {
				
				low = mid + 1;
			} else {
				
				high = mid - 1;
			
			}
		}
		return -1;
	}

}
