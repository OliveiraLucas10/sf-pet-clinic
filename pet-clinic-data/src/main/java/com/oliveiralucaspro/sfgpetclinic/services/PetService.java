package com.oliveiralucaspro.sfgpetclinic.services;

import java.util.Set;

import com.oliveiralucaspro.sfgpetclinic.model.Pet;

public interface PetService {

    Pet findById(Long id);

    Pet saveOwner(Pet pet);

    Set<Pet> findAll();

}
