package com.norris.pet.logic;

import com.norris.pet.database.Pet;
import com.norris.pet.database.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private PetRepository petRepository;

    @Autowired
    public PetService(@Lazy PetRepository petRepository){
        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }

    public Pet savePet(Pet pet){
        return petRepository.save(pet);
    }

    public Pet findById(String id){
        return petRepository.findById(id).orElse(null);
    }

    public String deletePet(String id){
        if(petRepository.existsById(id)){
            petRepository.deleteById(id);
            return "Success";
        }
        return "Fail!!!";
    }

}
