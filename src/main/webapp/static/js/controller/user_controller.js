'use strict';

angular.module('myApp').controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
    var self = this;
    self.animal={id:null,name:'',animalType:'',penName:'', areaName:'' , penId:0, areaId:0};
    self.animalsList=[];
    self.areaList=[];
    self.penList=[];
    self.animalTypesList=[];
    self.penObj={};
    self.typeObj={};
    self.areaObj={};
    self.animalCount = 0;

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
   

    fetchAllAnimals();
    fetchAllAreas();
    fetchAllAnimalTypes();
//    fetchAllPens();
   
    $scope.changeArea = function(areaObj){
      console.log("Area selected",areaObj);
      self.penList = areaObj.penList;
      self.animal.areaName = areaObj.areaName;
      self.animal.areaId = areaObj.id;
    }
    
    $scope.changePens = function(penObj){
        console.log("Pen selected",penObj);
    
        self.animal.penName = penObj.penName;
        self.animal.penId = penObj.id;
      }
    
    $scope.changeType = function(typeObj){
        console.log("Type selected",typeObj);
        self.animal.animalType = self.typeObj.typeName;
      }

    function validate(animalObj){
    	console.log("hello---",animalObj);
    
        for(var i = 0; i < self.animalsList.length; i++){
        	
        	
            if(self.animalsList[i].penId == animalObj.penId) {
            alert("Only one animal can be assigned in a Pen");
            return false;
            }
        }
        return true;
    }
    
    
    function validateArea(animalObj){
    	
	if(animalObj.animalType === "Birds"){
		console.log("inside area validation");
		if(self.animalsList.length !== 0){
			var data = self.animalsList.find( function( ele ) { 
    		    if(ele.areaName === animalObj.areaName && ele.animalType !== "Mammals"){
    		    	return ele;
    		    }
    		} );
     console.log("data after serach", data);
          if(data !== undefined && (data.animalType === "Reptiles")){
        	  alert("Reptiles cannot be in same area as Birds");
        	  return false
          }else{
        	  return true;  
          }
		}else {
			return true;
		}
    		
    		
    	}else if(animalObj.animalType === "Reptiles") {
    		console.log("inside area validation");
    		if(self.animalsList.length !== 0){
    			var data = self.animalsList.find( function( ele ) { 
        		    if(ele.areaName === animalObj.areaName && ele.animalType !== "Mammals"){
        		    	return ele;
        		    }
        		} );
         console.log("data after serach", data);
              if(data !== undefined && (data.animalType === "Birds")){
            	  alert("Reptiles cannot be in same area as Birds");
            	  return false
              }else{
            	  return true;  
              }
    		}else {
    			return true;
    		}
        		
    	}else {
    		return true;
    	}
    }
    
    function validateBear(animalObj){
    	console.log("Bear validation");
    	if(animalObj.name.toUpperCase() === 'BEAR'){
    		if(self.animalsList.length !== 0){
    			var data = self.animalsList.find( function( ele ) { 
        		    if(ele.areaName === animalObj.areaName && ele.animalType === "Birds"){
        		    	return ele;
        		    }
        		} );
         console.log("Bear data after serach", data);
              if(data !== undefined){
            	  alert("Bear cannot be in same area as Birds");
            	  return false
              }else{
            	  return true;  
              }
    		}else {
    			return true;
    		}
    		
    	}else {
    		return true;
    	}
    }

    function fetchAllAnimals(){
        UserService.fetchAllAnimals()
            .then(
            function(data) {
                self.animalsList = data;
                self.animalCount = self.animalsList.length;
                console.log("Animals list",self.animalsList);
            },
            function(errResponse){
                console.error('Error while fetching animal');
            }
        );
    }
    
    function fetchAllAnimalTypes(){
        UserService.fetchAllAnimalTypes()
            .then(
            function(data) {
                self.animalTypesList = data;
                console.log("Animals Type list",self.animalTypesList);
            },
            function(errResponse){
                console.error('Error while fetching animal types list');
            }
        );
    }
    
    function fetchAllAreas(){
        UserService.fetchAllAreas()
            .then(
            function(data) {
                self.areaList = data;
                console.log("Area list",self.areaList);
            },
            function(errResponse){
                console.error('Error while fetching Area List');
            }
        );
    }
    
//    function fetchAllPens(){
//        UserService.fetchAllPens()
//            .then(
//            function(data) {
//            	
//                self.penList = data;
//                console.log("Pens list",self.penList);
//            },
//            function(errResponse){
//                console.error('Error while fetching Pens');
//            }
//        );
//    }
    
    function createAnimal(animal){
    	console.log("Create Animal:",animal);
        UserService.createAnimal(animal)
            .then(
            fetchAllAnimals,
            function(errResponse){
                console.error('Error while creating animal');
            }
        );
    }

//    function createUser(user){
//        UserService.createUser(user)
//            .then(
//            fetchAllAnimals,
//            function(errResponse){
//                console.error('Error while creating animal');
//            }
//        );
//    }

    function updateUser(user, id){
        UserService.updateUser(user, id)
            .then(
            fetchAllAnimals,
            function(errResponse){
                console.error('Error while updating animal');
            }
        );
    }

    function deleteUser(id){
        UserService.deleteUser(id)
            .then(
            fetchAllAnimals,
            function(errResponse){
                console.error('Error while deleting animal');
            }
        );
    }

    function submit() {
    	
    	//console.log("validate--->", validateArea(self.animal));
    	
   	if(validate(self.animal) && (validateArea(self.animal) && validateBear(self.animal))){
    		
    	//if(validate(self.animal)){
    	
        if(self.animal.id===null){
        	
//        	self.animal.animalType = self.typeObj.typeName;
            console.log('Saving New animal', self.animal);
//            console.log('Selected pen object', self.penObj)

            createAnimal(self.animal);
        }else{
            updateUser(self.animal, self.animal.id);
            console.log('Animal updated with id ', self.animal.id);
        }
        reset();
    }
    	return;
    	
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.animalsList.length; i++){
            if(self.animalsList[i].id === id) {
                self.animal = angular.copy(self.animalsList[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.animal.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteUser(id);
    }


    function reset(){
    	  self.animal={id:null,name:'',animalType:'',penName:'', areaName:'' , penId:'', areaId:''};
    	  self.penObj = {};
    	  self.areaObj = {};
    	  self.typeObj = {};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
