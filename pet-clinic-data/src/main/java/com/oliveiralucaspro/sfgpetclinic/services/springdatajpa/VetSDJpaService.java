package com.oliveiralucaspro.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.oliveiralucaspro.sfgpetclinic.model.Vet;
import com.oliveiralucaspro.sfgpetclinic.repositories.VetRepository;
import com.oliveiralucaspro.sfgpetclinic.services.VetService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Profile("springdatajpa")
public class VetSDJpaService implements VetService{

    private final VetRepository vetRepository;
    
    @Override
    public Set<Vet> findAll() {
	Set<Vet> vets = new HashSet<>();
	vetRepository.findAll().forEach(vets::add);
	return vets;
    }

    @Override
    public Vet findById(Long id) {
	return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
	return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
	vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
	vetRepository.deleteById(id);
    }

}
