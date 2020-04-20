package com.zoomanagement.springmvc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.zoomanagement.springmvc.model.Animal;



@Service("animalService")
public class AnimalServiceImpl implements AnimalService {
	
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Animal> animals;
	
	static{
		animals= populateAnimalsList();
	}
	
	
	//------------------------------ Method to populate Dummy List of Animals-------------
	
	private static List<Animal> populateAnimalsList(){
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal(counter.incrementAndGet(),"Lion", "Mammals", counter.incrementAndGet(),counter.incrementAndGet(),"P1","A1"));
		animals.add(new Animal(counter.incrementAndGet(),"Ostriches", "Birds", counter.incrementAndGet(),counter.incrementAndGet(),"P2","A2"));
		animals.add(new Animal(counter.incrementAndGet(),"Snake", "Reptiles", counter.incrementAndGet(),counter.incrementAndGet(),"P3","A3"));
		return animals;
	}

	@Override
	public List<Animal> findAllAnimals() {
		
		return animals;
	}

	
	@Override
	public Animal findById(long id) {
		for(Animal animal : animals){
			if(animal.getId() == id){
				return animal;
			}
		}
		return null;
	}

	@Override
	public Animal findByName(String name) {
		for(Animal animal : animals){
			if(animal.getName().equalsIgnoreCase(name)){
				return animal;
			}
		}
		return null;
	}

	@Override
	public void saveAnimal(Animal animal) {
		
		if(validate(animal)) {
			AnimalFactory factory = new AnimalFactory();
			Animal obj = factory.getAnimal(animal);
			obj.setId(counter.incrementAndGet());
			animals.add(obj);	
		}
		
		
		
	}
	//--------------------------- Validation for Reptiles and Birds in same area----------------------
	public boolean validate(Animal obj) {
		
		if(obj.getName().equalsIgnoreCase("Bear")) {
			for (Iterator<Animal> iterator = animals.iterator(); iterator.hasNext(); ) {
				Animal animal = iterator.next();
				
			    if (animal.getAreaName().equals(obj.getAreaName()) && animal.getAnimalType().equals("Birds")) {
			    	System.out.print("Birds cannot be in adjacent Pen to bear");
			    	return false;
			    } 
			}
			
		}
		
		if(obj.getAnimalType().equals("Birds")) {
			for (Iterator<Animal> iterator = animals.iterator(); iterator.hasNext(); ) {
				Animal animal = iterator.next();
				if (animal.getAreaName().equals(obj.getAreaName()) && animal.getName().equalsIgnoreCase("Bear")) {
			    	System.out.print("Birds cannot be in adjacent Pen to bear");
			    	return false;
			    } 
				
				if (animal.getAreaName().equals(obj.getAreaName()) && animal.getAnimalType().equals("Reptiles")) {
			    	System.out.print("Birds cannot be in same are as Reptiles");
			    	return false;
			    } 
			}
		}else if(obj.getAnimalType().equals("Reptiles")) {
			for (Iterator<Animal> iterator = animals.iterator(); iterator.hasNext(); ) {
				Animal animal = iterator.next();
				
			    if (animal.getAreaName().equals(obj.getAreaName()) && animal.getAnimalType().equals("Birds")) {
			    	System.out.print("Reptiles cannot be in same are as Birds");
			    	return false;
			    } 
			}
		}
			return true;
		
	
	}

	@Override
	public void updateAnimal(Animal animal) {
		int index = animals.indexOf(animal);
		animals.set(index, animal);
		
	}

	@Override
	public void deleteAnimalById(long id) {
		for (Iterator<Animal> iterator = animals.iterator(); iterator.hasNext(); ) {
			Animal animal = iterator.next();
		    if (animal.getId() == id) {
		        iterator.remove();
		    }
		}
		
	}


	@Override
	public void deleteAllAnimals() {
		animals.clear();
		
	}

	@Override
	public boolean isAnimalExist(Animal animal) {
		return findByName(animal.getName())!=null;
	}

}
