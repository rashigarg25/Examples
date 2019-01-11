package com.practice.designpattern.factory;

public class AnimalFactory {

	public Animal getAnimal(String animalName) {

		Animal animal = null;
		if ("cat".equals(animalName)) {
			animal = new Cat();
		} else if ("dog".equals(animalName)) {
			animal = new Dog();
		} else if ("lion".equals(animalName)) {
			animal = new Lion();
		}
		return animal;
	}

}
