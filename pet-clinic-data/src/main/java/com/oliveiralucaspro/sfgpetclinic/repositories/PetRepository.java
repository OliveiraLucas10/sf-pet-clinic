package com.oliveiralucaspro.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.oliveiralucaspro.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long>{

}
