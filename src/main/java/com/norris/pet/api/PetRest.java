package com.norris.pet.api;

import com.norris.pet.database.Pet;
import com.norris.pet.logic.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetRest {

    private PetService petService;

    @Autowired
    public PetRest(@Lazy PetService petService) { this.petService = petService; }

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @PostMapping
    public Pet insertPet(@RequestBody Pet pet){
        if(pet.getId() == null || petService.findById(pet.getId()) == null){
            return petService.savePet(pet);
        }
        return null;
    }

    @PutMapping("/{petId}")
    public Pet updatePet(@RequestBody Pet pet, @PathVariable String petId){
        if(petId != null && petService.findById(petId) != null){
            pet.setId(petId);
            return petService.savePet(pet);
        }
        return null;
    }

    @DeleteMapping("/{petId}")
    public String deletePet(@PathVariable String petId){
        return petService.deletePet(petId);
    }

}
