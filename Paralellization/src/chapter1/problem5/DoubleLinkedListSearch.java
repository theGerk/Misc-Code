/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1.problem5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benji
 */
public class DoubleLinkedListSearch<E> extends Thread
{

	E target;
	Iterator<E> iterator;
	int distance;
	int result = 0;

	@Override
	public void run()
	{
		for (; result < distance; result++) {
			if (target.equals(iterator.next())) {
				return;
			}
		}
		result = -1;
	}

	private DoubleLinkedListSearch(E target, Iterator<E> itr, int distance)
	{
		this.target = target;
		this.iterator = itr;
		this.distance = distance;
	}

	public static <E> int Search(LinkedList<E> lst, E target)
	{
		DoubleLinkedListSearch<E> front, back;
		front = new DoubleLinkedListSearch<>(target, lst.iterator(), lst.size() / 2 + 1);
		front.start();
		back = new DoubleLinkedListSearch<>(target, lst.iterator(), lst.size() / 2 + 1);
		back.start();
		try {
			front.join();
			back.join();
		} catch (InterruptedException ex) {
			Logger.getLogger(DoubleLinkedListSearch.class.getName()).log(Level.SEVERE, null, ex);
		}
		if (front.result == -1) {
			return back.result;
		} else {
			return front.result;
		}
	}
}
