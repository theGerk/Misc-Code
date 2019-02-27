/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatest;

/**
 *
 * @author Benji
 */
public class JavaTest {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		int i;
		for (i = 0; i < 100; i++) {
			if (i == 20) {
				break;
			}
		}
		System.out.println(i);
	}

	public static String filter(String input) {
		int i = 0;
		while (i < input.length()) {
			for (; i < input.length(); i++) {
				if (input.charAt(i) == 0) {
					break;
				}
			}

			for (; i < input.length(); i++) {

			}
		}
	}

}
