
package com.practice.optional;

public class PojoUse {

	public static void main(String[] args) {

		Pojo1 pojo1 = new Pojo1();
		int value1 = pojo1.getValue1().orElse(2);
		//value1.EMPTY;
	}
}
