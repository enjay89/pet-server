package com.norris.pet.api;

import com.norris.pet.database.Pet;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetRest {

    @GetMapping
    public List<Pet> getAllPets() {
        return new ArrayList<>();
    }

    @PostMapping
    public Pet insertPet(@RequestBody Pet pet){

    }
}
