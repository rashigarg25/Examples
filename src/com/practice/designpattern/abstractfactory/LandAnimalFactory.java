package com.practice.designpattern.abstractfactory;

public class LandAnimalFactory extends AnimalFactory {

	@Override
	public Animal getAnimal(String animalName) {
		if ("dog".equals(animalName)) {
			return new Dog();
		} else if ("cat".equals(animalName)) {
			return new Cat();
		} else if ("lion".equals(animalName)) {
			return new Lion();
		}
		return null;
	}

}
