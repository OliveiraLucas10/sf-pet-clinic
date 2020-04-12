package com.oliveiralucaspro.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.oliveiralucaspro.sfgpetclinic.model.Visit;
import com.oliveiralucaspro.sfgpetclinic.repositories.VisitRepository;
import com.oliveiralucaspro.sfgpetclinic.services.VisitService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

    private final VisitRepository visitRepository;

    @Override
    public Set<Visit> findAll() {
	Set<Visit> visits = new HashSet<>();
	visitRepository.findAll().forEach(visits::add);
	return visits;
    }

    @Override
    public Visit findById(Long id) {
	return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
	return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
	visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
	visitRepository.deleteById(id);
    }

}
