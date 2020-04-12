package com.oliveiralucaspro.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.oliveiralucaspro.sfgpetclinic.model.Pet;
import com.oliveiralucaspro.sfgpetclinic.repositories.PetRepository;
import com.oliveiralucaspro.sfgpetclinic.services.PetService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

    private final PetRepository petRepository;

    @Override
    public Set<Pet> findAll() {
	Set<Pet> pets = new HashSet<>();
	petRepository.findAll().forEach(pets::add);
	return pets;
    }

    @Override
    public Pet findById(Long id) {
	return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
	return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
	petRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
	petRepository.deleteById(id);
    }

}
