package com.kakaye.graphqllearning1.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.kakaye.graphqllearning1.entity.Dog;
import com.kakaye.graphqllearning1.repository.DogRepository;
import com.kakaye.graphqllearning1.service.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed(String breed){
        boolean deleted = false;

        Iterable<Dog> allDogs = dogRepository.findAll();

        for (Dog d:allDogs){
            if (d.getBreed().equals(breed)){
                dogRepository.delete(d);
                deleted = true;
            }
        }

        if (!deleted){
            throw new DogNotFoundException("Breed not found",breed);
        }

        return deleted;
    }

    public Dog updateDogName(String newName,Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if (optionalDog.isPresent()){
            Dog dog = optionalDog.get();

            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        }else{
            throw new DogNotFoundException("Dog not found",id);
        }
    }
}
