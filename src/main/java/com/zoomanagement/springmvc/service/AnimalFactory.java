package com.zoomanagement.springmvc.service;

import com.zoomanagement.springmvc.model.Animal;
import com.zoomanagement.springmvc.model.Birds;
import com.zoomanagement.springmvc.model.Mammals;
import com.zoomanagement.springmvc.model.Reptiles;

public class AnimalFactory {

	
	final String BIRDS = "Birds";
	final String REPTILES  = "Reptiles";
	final String MAMMALS  = "Mammals";
	
	//Use getAnimal method to get object of type of Object   
	//It is factory method for object of type Animal
    public Animal getAnimal(Animal animal){  
    	if(BIRDS.equals(animal.getAnimalType())) {  
    		Birds birdObj = new Birds("Can Fly");
    		//birdObj.setId(animal.getId());
    		birdObj.setAnimalType(animal.getAnimalType());
    		birdObj.setAreaId(animal.getAreaId());
    		birdObj.setAreaName(animal.getAreaName());
    		birdObj.setName(animal.getName());
    		birdObj.setPenId(animal.getPenId());
    		birdObj.setPenName(animal.getPenName());
    		return birdObj;
    	}else if(REPTILES.equals(animal.getAnimalType())){  
    		Reptiles reptileObj = new Reptiles();
    		//reptileObj.setId(animal.getId());
    		reptileObj.setAnimalType(animal.getAnimalType());
    		reptileObj.setAreaId(animal.getAreaId());
    		reptileObj.setAreaName(animal.getAreaName());
    		reptileObj.setName(animal.getName());
    		reptileObj.setPenId(animal.getPenId());
    		reptileObj.setPenName(animal.getPenName());
    		return reptileObj;
    	}else if(MAMMALS.equals(animal.getAnimalType())) {
    		Mammals mammalsObj = new Mammals();
    		//mammalsObj.setId(animal.getId());
    		mammalsObj.setAnimalType(animal.getAnimalType());
    		mammalsObj.setAreaId(animal.getAreaId());
    		mammalsObj.setAreaName(animal.getAreaName());
    		mammalsObj.setName(animal.getName());
    		mammalsObj.setPenId(animal.getPenId());
    		mammalsObj.setPenName(animal.getPenName());
    		return mammalsObj;
    	} 
    	
    	return null; 
}
}
