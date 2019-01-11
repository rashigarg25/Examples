package com.practice.designpattern.abstractfactory;

public abstract class AnimalFactory {

	public abstract Animal getAnimal(String animalName);

	public static AnimalFactory getAnimalFactory(String animalType) {

		AnimalFactory animalFactory = null;
		if ("land".equals(animalType)) {
			animalFactory = new LandAnimalFactory();
		} else if ("sea".equals(animalType)) {
			animalFactory = new SeaAnimalFactory();
		}
		return animalFactory;
	}

}
