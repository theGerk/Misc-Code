/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parallelization;

import chapter1.problem2.ParallelSearch;
import chapter1.problem4.MergeSort;
import java.util.Random;

/**
 *
 * @author Benji
 */
public class Main
{

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args)
	{
		Random rand = new Random();

		int[] A = new int[100];
		for (int i = 0; i < A.length; i++) {
			A[i] = rand.nextInt();
		}
		int target = A[42];
		System.out.println(ParallelSearch.parallelSearch(target, A, 40));
		System.out.println(ParallelSearch.parallelSearch(target, MergeSort.Sort(A), 40));

	}
}
