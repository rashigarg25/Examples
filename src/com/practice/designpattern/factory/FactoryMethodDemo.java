package com.practice.designpattern.factory;

public class FactoryMethodDemo {

	public static void main(String[] args) {

		AnimalFactory animalFactory = new AnimalFactory();
		animalFactory.getAnimal("cat").speak();
		animalFactory.getAnimal("dog").speak();
		animalFactory.getAnimal("lion").speak();
	}
}
