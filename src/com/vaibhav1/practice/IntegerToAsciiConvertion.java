/**
 * 
 */
package com.vaibhav1.practice;

/**
 * @author vshukla 
 * Problem Statement: Given a integer , return corresponding ASCII char representation without using language building in feature.
 *         ex. input integer 1234, return "1234" in string or characters
 */
public class IntegerToAsciiConvertion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 1234;
		System.out.println(integerToCharConvertion(num));

	}

	/**
	 * The idea is to extract each digit from the num and append it to a String
	 * result. Finally, reversing the string result.
	 * 
	 * @param num
	 *            - input integer number
	 * @return char representation
	 */
	public static String integerToCharConvertion(int num) {
		String result = "";
		while (num > 0) {
			int digit = num % 10;
			result += digit;
			num = num / 10;

		}
		return reverse(result);
	}

	/**
	 * Method to reverse the String
	 * 
	 * @param result
	 *            - input String
	 * @return reverse format
	 */
	private static String reverse(String result) {
		StringBuilder sb = new StringBuilder("");
		sb.append(result);
		sb = sb.reverse();
		return sb.toString();
	}
}
