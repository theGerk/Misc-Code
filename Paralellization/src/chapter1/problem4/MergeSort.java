/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1.problem4;

import java.lang.reflect.Array;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benji
 * @param <T>
 */
public class MergeSort<T extends Comparable<T>> extends Thread
{

	public static int[] Sort(int[] A)
	{
		Integer[] Arr = new Integer[A.length];
		for (int i = 0; i < A.length; i++) {
			Arr[i] = A[i];
		}
		Sort(Arr);
		for (int i = 0; i < A.length; i++) {
			A[i] = Arr[i];
		}
		return A;
	}

	T[] arr;
	int start;
	int length;

	/**
	 *
	 */
	@Override
	public void run()
	{
		//split
		int lengthA = length / 2;
		int lengthB = length - lengthA;

		{
			MergeSort A = null, B = null;
			if (lengthA > 1) {
				A = new MergeSort(arr, start, lengthA);
				A.start();
			}
			if (lengthB > 1) {
				B = new MergeSort(arr, start + lengthA, lengthB);
				B.start();
			}

			try {
				if (A != null) {
					A.join();
				}
				if (B != null) {
					B.join();
				}
			} catch (InterruptedException ex) {
				Logger.getLogger(MergeSort.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		//and merge
		if (length == 2) {
			if (arr[start].compareTo(arr[start + 1]) > 0) {
				T tmp = arr[start];
				arr[start] = arr[start + 1];
				arr[start + 1] = tmp;
			}
		} else if (length > 2) {
			T[] tmp = (T[]) Array.newInstance(arr[0].getClass(), length);
			{
				int i = 0;
				int a = start;
				int b = start + lengthA;
				int complete = 0;
				while (i < length) {
					if (arr[a].compareTo(arr[b]) < 0) {
						tmp[i++] = arr[a++];
						if (a >= start + lengthA) {
							complete = b;
							break;
						}
					} else {
						tmp[i++] = arr[b++];
						if (b >= start + length) {
							complete = a;
							break;
						}
					}
				}

				while (i < length) {
					tmp[i++] = arr[complete++];
				}
			}

			System.arraycopy(tmp, 0, arr, start, length);
		}
	}

	private MergeSort(T[] array, int start, int length)
	{
		arr = array;
		this.start = start;
		this.length = length;
	}

	public static <T extends Comparable<T>> T[] Sort(T[] arr)
	{
		MergeSort sort = new MergeSort(arr, 0, arr.length);
		sort.start();
		try {
			sort.join();
		} catch (InterruptedException ex) {
			Logger.getLogger(MergeSort.class.getName()).log(Level.SEVERE, null, ex);
		}
		return arr;
	}
}
