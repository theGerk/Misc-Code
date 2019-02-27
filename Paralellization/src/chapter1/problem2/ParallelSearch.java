/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1.problem2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benji
 */
public class ParallelSearch extends Thread
{

	final int[] Arr;
	int start;
	int end;
	int search;
	int result = -1;

	private ParallelSearch(final int[] Array, int startIndex, int length, int target)
	{
		super();
		Arr = Array;
		start = startIndex;
		this.end = length > Arr.length - start ? Arr.length : start + length;
		search = target;
	}

	@Override
	public void run()
	{
		//System.out.println("range: [" + start + "," + end + ")");
		for (int i = start; i < end; i++) {
			if (Arr[i] == search) {
				result = i;
				return;
			}
		}
	}

	public static int parallelSearch(int x, int[] A, int numThreads)
	{
		//rounds up division
		//figure out good way to distribute
		int lengthPerThread = (A.length - 1) / numThreads + 1;
		ParallelSearch[] searches = new ParallelSearch[numThreads];
		for (int i = 0; i < numThreads; i++) {
			searches[i] = new ParallelSearch(A, i * lengthPerThread, lengthPerThread, x);
			searches[i].start();
		}
		try {
			for (int i = 0; i < numThreads; i++) {
				searches[i].join();
				if (searches[i].result != -1) {
					return searches[i].result;
				}
			}
		} catch (InterruptedException ex) {
			Logger.getLogger(ParallelSearch.class.getName()).log(Level.SEVERE, null, ex);
		}
		return -1;
	}
}
