package com.kakaye.graphqllearning1.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.kakaye.graphqllearning1.entity.Dog;
import com.kakaye.graphqllearning1.repository.DogRepository;
import com.kakaye.graphqllearning1.service.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs(){
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if (optionalDog.isPresent()){
            return optionalDog.get();
        }else{
            throw  new DogNotFoundException("Dog Not found",id);
        }
    }


}
