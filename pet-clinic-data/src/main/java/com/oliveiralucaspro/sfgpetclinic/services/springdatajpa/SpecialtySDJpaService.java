package com.oliveiralucaspro.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.oliveiralucaspro.sfgpetclinic.model.Specialty;
import com.oliveiralucaspro.sfgpetclinic.repositories.SpecialtyRepository;
import com.oliveiralucaspro.sfgpetclinic.services.SpecialtyService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService{
    
    private final SpecialtyRepository specialtyRepository;
    
    @Override
    public Set<Specialty> findAll() {
	Set<Specialty> specialties = new HashSet<>();
	specialtyRepository.findAll().forEach(specialties::add);
	return specialties;
    }

    @Override
    public Specialty findById(Long id) {
	return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
	return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
	specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
	specialtyRepository.deleteById(id);
    }

}
