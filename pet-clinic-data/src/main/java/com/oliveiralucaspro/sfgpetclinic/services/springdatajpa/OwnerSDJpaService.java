package com.oliveiralucaspro.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.oliveiralucaspro.sfgpetclinic.model.Owner;
import com.oliveiralucaspro.sfgpetclinic.repositories.OwnerRepository;
import com.oliveiralucaspro.sfgpetclinic.repositories.PetRepository;
import com.oliveiralucaspro.sfgpetclinic.services.OwnerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;

    @Override
    public Set<Owner> findAll() {
	Set<Owner> owners = new HashSet<>();
	ownerRepository.findAll().forEach(owners::add);
	return owners;
    }

    @Override
    public Owner findById(Long id) {
	return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
	return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
	ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
	ownerRepository.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
	return ownerRepository.findByLastName(lastName);
    }

}
