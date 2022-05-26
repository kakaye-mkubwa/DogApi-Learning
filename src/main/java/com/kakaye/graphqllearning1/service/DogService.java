package com.kakaye.graphqllearning1.service;

import com.kakaye.graphqllearning1.entity.Dog;

import java.util.List;

public interface DogService {
    List<Dog> retrieveAllDogs();
//    List<String> retrieveAllDogBreeds();
//    List<String> retrieveAllDogNames();
//    String retrieveDogBreedByID(Long id);
}
