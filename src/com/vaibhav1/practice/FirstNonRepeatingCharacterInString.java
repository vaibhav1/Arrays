/**
 * 
 */
package com.vaibhav1.practice;

/**
 * @author vshukla
 * Problem Statement:  	Given a string, return the first non-repeating character.
 * 						For e.g. String s = "indiaisagreatnation" , first non-repeating character is d
 */
public class FirstNonRepeatingCharacterInString {

	/*
	 * The idea is very simple. We will store each character's frequency 
	 * in an auxiliary count array of size 256 (total characters).
	 * We will then traverse the string again and check if the frequency of current character is 1, it is first non-repeating.
	 * 
	 * We can modify the code to find out the first REPEATING character in the string as well.
	 * Just find out the first character whose frequency is greater than 1.
	 */
	private static void firstNonRepeatingChar(String s) {
		int[] charCount = new int[256];
		
		char[] str = s.toCharArray();
		
		//create count array
		for(char c : str){
			charCount[c]++;
		}
		//traverse the string again and check for character's frequency
		for(char c : str){
			if(charCount[c]==1){
				System.out.println("first non-repeating character is:"+c);
				break;
			}
			
			/*
			 * FIRST REPEATING CHARACTER. In the above example, first repeating character is: i
			 *
			 *
			if(charCount[c]>1){
				System.out.println("first repeating character is:"+c);
				break;
			}
			*/
		}
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s = "indiaisagreatnation";
		firstNonRepeatingChar(s);

	}

}
