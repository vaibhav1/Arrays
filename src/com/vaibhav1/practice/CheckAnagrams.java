/**
 * 
 */
package com.vaibhav1.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author vshukla
 *	Problem Statement: Given two strings, check if they are anagrams to each other.
 *						For e.g. : "Listen" & "Silent" are anagrams  
 */
public class CheckAnagrams {

	/**
	 * The idea is to count each character in one string and store in a hashmap. Then traverse each character in String b and 
	 * decrement the character count. Finally, traverse the hashmap and check for count. If all counts are 0, then strings are anagrams. Else not.
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean areAnagrams(String a, String b){
		
		Map<Character, Integer> charCount = new HashMap<Character, Integer>();
		char[] arr1 = a.toCharArray();
		char[] arr2 = b.toCharArray();
		
		
		//count the characters & store frequency
		for(int i=0;i<arr1.length;i++){
			if(charCount.get(arr1[i])!=null){
				int value = charCount.get(arr1[i]);
				value+=1;
				charCount.put(arr1[i], value);
				
			} else {
				charCount.put(arr1[i], 1);
			}
			
		}
		
		//decrement count for second array characters
		for(int i=0;i<arr2.length;i++){
			if(charCount.get(arr2[i])==null){
				return false;
			} else {
				int value = charCount.get(arr2[i]);
				value-=1;
				charCount.put(arr2[i], value);
			}
		}
		
		//check hashmap for all 0s
		for(Entry<Character, Integer> e : charCount.entrySet()){
			if(e.getValue()!=0){
				return false;
			}
		}
		
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

			String a = "aas";
			String b = "saa";
			System.out.println(areAnagrams(a, b));
	}
	
	
}
