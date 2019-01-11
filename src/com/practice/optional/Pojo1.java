
package com.practice.optional;

import java.util.Optional;

public class Pojo1 {

	private int value1;
	private Integer value2;
	private String value3;

	public Optional<Integer> getValue1() {

		return Optional.of(value1);
	}

	public void setValue1(int value1) {

		this.value1 = value1;
	}

	public Optional<Integer> getValue2() {

		return Optional.of(value2);
	}

	public void setValue2(Integer value2) {

		this.value2 = value2;
	}

	public Optional<String> getValue3() {

		return Optional.of(value3);
	}

	public void setValue3(String value3) {

		this.value3 = value3;
	}
}
