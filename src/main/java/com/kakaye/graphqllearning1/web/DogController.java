package com.kakaye.graphqllearning1.web;

import com.kakaye.graphqllearning1.entity.Dog;

import com.kakaye.graphqllearning1.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {
    private DogService dogService;

    @Autowired
    private void setDogService(DogService dogService){
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> retrieveALlDogs(){
        return new ResponseEntity<List<Dog>>(dogService.retrieveAllDogs(), HttpStatus.OK);
    }
//
//    @GetMapping("/dog/breeds")
//    public ResponseEntity<List<String>> retrieveAllDogBreeds(){
//        return new ResponseEntity<List<String>>(dogService.retrieveAllDogBreeds(),HttpStatus.OK);
//    }
//
//    @GetMapping("/dog/names")
//    public ResponseEntity<List<String>> retrieveAllDogNames(){
//        return new ResponseEntity<List<String>>(dogService.retrieveAllDogNames(),HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}/breed")
//    public ResponseEntity<String> retrieveDogBreedById(@PathVariable Long id){
//        return new ResponseEntity<String>(dogService.retrieveDogBreedByID(id),HttpStatus.OK);
//    }
}
