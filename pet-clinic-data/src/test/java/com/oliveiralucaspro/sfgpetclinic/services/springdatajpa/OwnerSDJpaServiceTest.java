package com.oliveiralucaspro.sfgpetclinic.services.springdatajpa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.oliveiralucaspro.sfgpetclinic.model.Owner;
import com.oliveiralucaspro.sfgpetclinic.repositories.OwnerRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner returnedOwner;

    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
	returnedOwner = new Owner();
	returnedOwner.setId(1L);
	returnedOwner.setLastName(lastName);
    }

    @Test
    void testFindAll() {
	Owner owner = new Owner();
	returnedOwner.setId(2L);

	Set<Owner> returnedOwners = new HashSet<>();
	returnedOwners.add(returnedOwner);
	returnedOwners.add(owner);

	when(ownerRepository.findAll()).thenReturn(returnedOwners);

	Set<Owner> findAll = service.findAll();

	assertEquals(2, findAll.size());

    }

    @Test
    void testFindById() {
	when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnedOwner));

	Owner findById = service.findById(1L);

	assertNotNull(findById);
    }
    
    @Test
    void testFindByIdNotFound() {
	when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

	Owner findById = service.findById(1L);

	assertNull(findById);
    }

    @Test
    void testSave() {
	when(ownerRepository.save(any())).thenReturn(returnedOwner);

	Owner save = service.save(new Owner());

	assertNotNull(save);
    }

    @Test
    void testDelete() {
	service.delete(returnedOwner);

	verify(ownerRepository).delete(any());
    }

    @Test
    void testDeleteById() {
	service.deleteById(1L);

	verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void testFindByLastName() {
	when(ownerRepository.findByLastName(any())).thenReturn(returnedOwner);

	Owner findByLastName = service.findByLastName(lastName);

	assertEquals(lastName, findByLastName.getLastName());
	verify(ownerRepository).findByLastName(any());
    }

}
