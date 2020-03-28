package com.oliveiralucaspro.sfgpetclinic.services;

import java.util.Set;

import com.oliveiralucaspro.sfgpetclinic.model.Vet;

public interface VetService {

    Vet findById(Long id);

    Vet saveOwner(Vet vet);

    Set<Vet> findAll();

}
