package com.norris.pet.logic;

import com.norris.pet.database.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    private PetRepository petRepository;

    @Autowired
    public PetService(@Lazy PetRepository petRepository){
        this.petRepository = petRepository;
    }
}
