package com.oliveiralucaspro.sfgpetclinic.services.map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.oliveiralucaspro.sfgpetclinic.model.Owner;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    final Long ownerId = 1L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
	ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

	Owner owner = new Owner();
	owner.setId(ownerId);
	owner.setLastName(lastName);

	ownerMapService.save(owner);
    }

    @Test
    void testFindAll() {
	Set<Owner> findAll = ownerMapService.findAll();

	assertEquals(1, findAll.size());
    }

    @Test
    void testFindByIdLong() {
	Owner findById = ownerMapService.findById(ownerId);

	assertEquals(ownerId, findById.getId());
    }

    @Test
    void testSaveOwnerExistingId() {
	Long id = 2L;
	Owner owner = new Owner();
	owner.setId(id);

	Owner savedOwner = ownerMapService.save(owner);

	assertEquals(id, savedOwner.getId());
    }

    @Test
    void testSaveOwnerNoId() {
	Owner owner = new Owner();

	Owner savedOwner = ownerMapService.save(owner);

	assertNotNull(savedOwner);
	assertNotNull(savedOwner.getId());
    }

    @Test
    void testDeleteOwner() {
	ownerMapService.delete(ownerMapService.findById(ownerId));

	assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void testDeleteByIdLong() {
	ownerMapService.deleteById(ownerId);

	assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void testFindByLastName() {
	Owner findByLastName = ownerMapService.findByLastName(lastName);

	assertNotNull(findByLastName);
	assertEquals(lastName, findByLastName.getLastName());
    }

    @Test
    void testFindByLastNameNotFound() {
	Owner findByLastName = ownerMapService.findByLastName("Test");

	assertNull(findByLastName);
    }

}
