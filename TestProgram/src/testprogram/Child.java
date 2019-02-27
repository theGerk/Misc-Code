/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprogram;

/**
 *
 * @author Benji
 */
public class Child extends Parent {

	public Child() {
		super();
	}

	protected static void func() {
		System.out.println("in child");
	}

	protected int four = 4;
}
