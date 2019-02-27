
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner cin = new Scanner(System.in);
		String alphabet = cin.nextLine();
		int len = cin.nextInt();

		String first, last;
		first = last = alphabet.substring(0, len);

		for (int i = 1; i < alphabet.length() - len + 1; i++) {
			String cur = alphabet.substring(i, i + len);
			if (cur.compareTo(first) < 0) {
				first = cur;
			} else if (cur.compareTo(last) >= 0) {
				last = cur;
			}
		}

		System.out.println(first);
		System.out.println(last);
	}
}
