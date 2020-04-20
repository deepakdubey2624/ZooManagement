package com.zoomanagement.springmvc.service;

import java.util.List;

import com.zoomanagement.springmvc.model.Animal;


public interface AnimalService {

    Animal findById(long id);
	
	Animal findByName(String name);
	
	void saveAnimal(Animal animal);
	
	void updateAnimal(Animal animal);
	
	void deleteAnimalById(long id);

	List<Animal> findAllAnimals(); 
	
	void deleteAllAnimals();
	
	public boolean isAnimalExist(Animal animal);
}
