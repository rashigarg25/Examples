package com.practice.designpattern.abstractfactory;

public class AbstractFactoryDemo {

	public static void main(String[] args) {

		AnimalFactory animalFactory = AnimalFactory.getAnimalFactory("sea");

		animalFactory.getAnimal("dolphin").speaks();
		animalFactory.getAnimal("shark").speaks();

		animalFactory = AnimalFactory.getAnimalFactory("land");

		animalFactory.getAnimal("dog").speaks();
		animalFactory.getAnimal("cat").speaks();
		animalFactory.getAnimal("lion").speaks();

	}

}
