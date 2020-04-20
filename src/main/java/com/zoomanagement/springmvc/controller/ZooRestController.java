package com.zoomanagement.springmvc.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.zoomanagement.springmvc.model.Animal;
import com.zoomanagement.springmvc.model.Area;
import com.zoomanagement.springmvc.model.Pen;
import com.zoomanagement.springmvc.model.Type;
import com.zoomanagement.springmvc.service.AnimalService;
import com.zoomanagement.springmvc.service.AreaService;
import com.zoomanagement.springmvc.service.PenService;
import com.zoomanagement.springmvc.service.TypeService;

 
@RestController
public class ZooRestController {
 
   
    
    @Autowired
    AnimalService animalService;
    
    @Autowired
    PenService penService;
    
    @Autowired
    AreaService areaService;
    
    @Autowired
    TypeService typeService;
    //Service which will do all data retrieval/manipulation work
 
    
    
    //-------------------Retrieve All Animals--------------------------------------------------------
     
    @RequestMapping(value = "/animal/", method = RequestMethod.GET)
    public ResponseEntity<List<Animal>> listAllAnimals() {
        List<Animal> animals = animalService.findAllAnimals();
        if(animals.isEmpty()){
            return new ResponseEntity<List<Animal>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Animal>>(animals, HttpStatus.OK);
    }
 
    //------------------------------------Retrieve All Pens-----------------------------------
    @RequestMapping(value = "/pens/", method = RequestMethod.GET)
    public ResponseEntity<List<Pen>> listPens() {
        List<Pen> pens = penService.getPenListForDropDown();
        if(pens.isEmpty()){
            return new ResponseEntity<List<Pen>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Pen>>(pens, HttpStatus.OK);
    }
 
    //------------------------------------Retrieve All Areas-----------------------------------
    @RequestMapping(value = "/areas/", method = RequestMethod.GET)
    public ResponseEntity<List<Area>> listAreas() {
        List<Area> areaList = areaService.getAreaListForDropDown();
        
        if(areaList.isEmpty()){
            return new ResponseEntity<List<Area>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Area>>(areaList, HttpStatus.OK);
    }
    
    //------------------------------------Retrieve All Animal Types-----------------------------------
    @RequestMapping(value = "/animalTypes/", method = RequestMethod.GET)
    public ResponseEntity<List<Type>> listAnimalTypes() {
        List<Type> typeList = typeService.getAnimalTypeListForDropDown();
        
        if(typeList.isEmpty()){
            return new ResponseEntity<List<Type>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Type>>(typeList, HttpStatus.OK);
    }
 
    
    //-------------------Retrieve Single Animal--------------------------------------------------------
     
    @RequestMapping(value = "/animal/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Animal> getAnimal(@PathVariable("id") long id) {
        System.out.println("Fetching Animal with id " + id);
        Animal animal = animalService.findById(id);
        if (animal == null) {
            System.out.println("Animal with id " + id + " not found");
            return new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Animal>(animal, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Animal--------------------------------------------------------
     
    @RequestMapping(value = "/animal/", method = RequestMethod.POST)
    public ResponseEntity<Void> createAnimal(@RequestBody Animal animal,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Animal " + animal.getName());
 
        if (animalService.isAnimalExist(animal)) {
            System.out.println("A animal with name " + animal.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        animalService.saveAnimal(animal);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/animal/{id}").buildAndExpand(animal.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a Animal --------------------------------------------------------
     
    @RequestMapping(value = "/animal/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Animal> updateUser(@PathVariable("id") long id, @RequestBody Animal animal) {
        System.out.println("Updating Animal " + id);
         
        Animal currentAnimal = animalService.findById(id);
         
        if (currentAnimal==null) {
            System.out.println("Animal with id " + id + " not found");
            return new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
        }
 
        currentAnimal.setName(animal.getName());
        currentAnimal.setAnimalType(animal.getAnimalType());
        currentAnimal.setPenId(animal.getPenId());
        currentAnimal.setAreaId(animal.getAreaId());
        currentAnimal.setPenName(animal.getPenName());
        currentAnimal.setAreaName(animal.getAreaName());
        
       
         
        animalService.updateAnimal(currentAnimal);
        return new ResponseEntity<Animal>(currentAnimal, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a Animal --------------------------------------------------------
     
    @RequestMapping(value = "/animal/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Animal> deleteAnimal(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Animal with id " + id);
 
        Animal animal = animalService.findById(id);
        if (animal == null) {
            System.out.println("Unable to delete. Animal with id " + id + " not found");
            return new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
        }
 
        animalService.deleteAnimalById(id);
        return new ResponseEntity<Animal>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All Animals --------------------------------------------------------
     
    @RequestMapping(value = "/animal/", method = RequestMethod.DELETE)
    public ResponseEntity<Animal> deleteAllUsers() {
        System.out.println("Deleting All Animals");
 
        animalService.deleteAllAnimals();
        return new ResponseEntity<Animal>(HttpStatus.NO_CONTENT);
    }
 
}