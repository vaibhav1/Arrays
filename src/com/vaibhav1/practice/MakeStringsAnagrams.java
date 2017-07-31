/**
 * 
 */
package com.vaibhav1.practice;

import java.util.Arrays;

/**
 * @author vshukla
 * 
 * Problem Statement: 	Given two strings,  and , that may or may not be of the same length, 
 * 						determine the minimum number of character deletions required to make the strings anagrams. 
 * 						Any characters can be deleted from either of the strings.
 * 						For eg: input : cde, abc. Output : 4
 * 						Explanation: We delete the following characters from our two strings to turn them into anagrams of each other:
 *									 1. Remove d and e from cde to get c.
 * 									 2. Remove a and b from abc to get c.
 *						We must delete 4 characters to make both strings anagrams, so we print 4 on a new line.
 *
 */
public class MakeStringsAnagrams {
	
	
    public static void main(String[] args) {
        String a = "cde";
        String b = "abc";
        System.out.println(numberNeeded(a, b));
        
        
    }

	
	/**
	 * The idea is to identify the common characters in both strings. Then removing all the non-common characters in both string. 
	 * Ideally, Strings will be anagrams if they have similar characters
	 * Basically we don't literally remove the characters but play with String length as we just have to return the total no. of characters to be removed.
	 * 
	 * In above example, common character is c. Total common character = 1. Total non common characters =  string.length()-total common characters
	 * Doing it for both Strings : 	string1.length-total_common + string2.length - total_common
	 * 								i.e string1.length+string2.length - 2*total_common
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static int numberNeeded(String first, String second) {
        char []arr1 = first.toCharArray();
        char []arr2 = second.toCharArray();
        
        //sorting both strings would help in identifying common characters easily.
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        int totalCommonElements = getIntersection(arr1,arr2);
        
        int deleteCharacters = arr1.length+arr2.length-2*totalCommonElements;
        
        return deleteCharacters;
    }
  
    
    /**
     * Method to find total no. of common characters in both strings or character arrays
     * @param arr1 - array1
     * @param arr2 - array2
     * @return total no. of common characters
     */
    public static int getIntersection(char[] arr1, char[] arr2){
        int i=0;
        int j=0;
        int count = 0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i] < arr2[j]){
                i++;
            } else if(arr1[i]>arr2[j]){
                j++;
            } else{
                count++;
                i++;
                j++;
            }
        }
        
        return count;
    }

}
