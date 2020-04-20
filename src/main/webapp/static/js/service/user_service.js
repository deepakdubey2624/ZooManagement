'use strict';

angular.module('myApp').factory('UserService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/ZooManagement/animal/';
    var PENS_SERVICE_URI = 'http://localhost:8080/ZooManagement/pens/';
    var AREAS_SERVICE_URI = 'http://localhost:8080/ZooManagement/areas/';
    var ANIMAL_TYPES_SERVICE_URI = 'http://localhost:8080/ZooManagement/animalTypes/';
    
    var factory = {
        fetchAllAnimals: fetchAllAnimals,
        createAnimal: createAnimal,
        updateUser:updateUser,
        deleteUser:deleteUser,
        fetchAllPens:fetchAllPens,
        fetchAllAreas:fetchAllAreas,
        fetchAllAnimalTypes:fetchAllAnimalTypes
    };

    return factory;

    
    function fetchAllAnimalTypes() {
  	  console.log('Animal Type List Service URL',ANIMAL_TYPES_SERVICE_URI);
      var deferred = $q.defer();
      $http.get(ANIMAL_TYPES_SERVICE_URI)
          .then(
          function (response) {
              deferred.resolve(response.data);
          },
          function(errResponse){
              console.error('Error while fetching Animal Types List');
              deferred.reject(errResponse);
          }
      );
      return deferred.promise;
  }
    
    function fetchAllAreas() {
    	  console.log('Area List Service URL',AREAS_SERVICE_URI);
        var deferred = $q.defer();
        $http.get(AREAS_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Area List');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function fetchAllPens() {
  	  console.log('Pen List Service URL',PENS_SERVICE_URI);
      var deferred = $q.defer();
      $http.get(PENS_SERVICE_URI)
          .then(
          function (response) {
              deferred.resolve(response.data);
          },
          function(errResponse){
              console.error('Error while fetching Pen List');
              deferred.reject(errResponse);
          }
      );
      return deferred.promise;
  }
    
    function fetchAllAnimals() {
    	  console.log('Base URL',REST_SERVICE_URI);
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Animals');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createAnimal(animal) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, animal)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Animal');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateUser(user, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Animal');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteUser(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Animal');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
