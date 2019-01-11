
package com.practice.functional.interf;

@FunctionalInterface
public interface FunctionalInterfaceTest {

	public void getId();

	default void getName() {

	}
}
