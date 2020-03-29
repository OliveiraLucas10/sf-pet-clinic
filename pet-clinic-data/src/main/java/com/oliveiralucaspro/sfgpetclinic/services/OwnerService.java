package com.oliveiralucaspro.sfgpetclinic.services;

import com.oliveiralucaspro.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
