
package com.practice.oops;

public class Child extends Parent {

	@Override
	public void display() {

		super.display();
		populate();
		System.out.println("child");

	}

	@Override
	public void populate() {
		System.out.println("Child populate");
	}

	public static void main(String args[]) {

		Parent p = new Child();
		p.display();
	}
}
