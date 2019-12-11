package com.norris.pet.database;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends MongoRepository<Pet, String> {}
