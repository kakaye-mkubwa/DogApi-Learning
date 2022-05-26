package com.kakaye.graphqllearning1.service;

import com.kakaye.graphqllearning1.entity.Dog;
import com.kakaye.graphqllearning1.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {
    @Autowired
    DogRepository dogRepository;

    @Override
    public List<Dog> retrieveAllDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

//    @Override
//    public List<String> retrieveAllDogBreeds() {
//        return dogRepository.findAllBreed();
//    }
//
//    @Override
//    public List<String> retrieveAllDogNames() {
//        return dogRepository.findAllName();
//    }
//
//    @Override
//    public String retrieveDogBreedByID(Long id) {
//        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
//        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
//        return breed;
//    }
}
