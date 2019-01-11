package com.practice.designpattern.abstractfactory;

public class SeaAnimalFactory extends AnimalFactory {

	@Override
	public Animal getAnimal(String animalName) {
		if ("shark".equals(animalName)) {
			return new Shark();
		} else if ("dolphin".equals(animalName)) {
			return new Dolphin();
		}
		return null;
	}

}
