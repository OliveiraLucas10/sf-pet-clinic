package com.oliveiralucaspro.sfgpetclinic.services;

import java.util.Set;

import com.oliveiralucaspro.sfgpetclinic.model.Owner;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner saveOwner(Owner owner);

    Set<Owner> findAll();

}
