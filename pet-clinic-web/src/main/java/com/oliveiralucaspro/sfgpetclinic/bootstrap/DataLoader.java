package com.oliveiralucaspro.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.oliveiralucaspro.sfgpetclinic.model.Owner;
import com.oliveiralucaspro.sfgpetclinic.model.Pet;
import com.oliveiralucaspro.sfgpetclinic.model.PetType;
import com.oliveiralucaspro.sfgpetclinic.model.Speciality;
import com.oliveiralucaspro.sfgpetclinic.model.Vet;
import com.oliveiralucaspro.sfgpetclinic.services.OwnerService;
import com.oliveiralucaspro.sfgpetclinic.services.PetService;
import com.oliveiralucaspro.sfgpetclinic.services.PetTypeService;
import com.oliveiralucaspro.sfgpetclinic.services.SpecialtyService;
import com.oliveiralucaspro.sfgpetclinic.services.VetService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    @Override
    public void run(String... args) throws Exception {

	int count = petTypeService.findAll().size();

	if (count == 0) {
	    loadData();
	}

    }

    private void loadData() {
	PetType dog = new PetType();
	dog.setName("Dog");
	PetType savedDogPetType = petTypeService.save(dog);

	PetType cat = new PetType();
	dog.setName("Cat");
	PetType savedCatPetType = petTypeService.save(cat);

	Speciality radiology = new Speciality();
	radiology.setDescription("Radiology");
	Speciality savedRadiology = specialtyService.save(radiology);

	Speciality surgery = new Speciality();
	surgery.setDescription("Surgery");
	Speciality savedSurgery = specialtyService.save(surgery);

	Speciality dentistry = new Speciality();
	dentistry.setDescription("Dentistry");
	Speciality savedDentistry = specialtyService.save(dentistry);

	Owner owner1 = new Owner();
	owner1.setFirstName("Michael");
	owner1.setLastName("Weston");
	owner1.setAddress("123 Brickerel");
	owner1.setCity("Miamu");
	owner1.setTelephone("123456789");

	Pet mikesPet = new Pet();
	mikesPet.setPetType(savedDogPetType);
	mikesPet.setOwner(owner1);
	mikesPet.setBirthDate(LocalDate.now());
	mikesPet.setName("Rosco");
	owner1.getPets().add(mikesPet);

	ownerService.save(owner1);

	Owner owner2 = new Owner();
	owner2.setFirstName("Fiona");
	owner2.setLastName("Glenanne");
	owner2.setAddress("123 Brickerel");
	owner2.setCity("Miamu");
	owner2.setTelephone("123456789");

	Pet fionasCat = new Pet();
	fionasCat.setPetType(savedCatPetType);
	fionasCat.setOwner(owner2);
	fionasCat.setBirthDate(LocalDate.now());
	fionasCat.setName("Cat");
	owner2.getPets().add(fionasCat);

	ownerService.save(owner2);

	System.out.println("Loading Owners ....");

	Vet vet1 = new Vet();
	vet1.setFirstName("Sam");
	vet1.setLastName("Axe");
	vet1.getSpecialities().add(savedRadiology);

	vetService.save(vet1);

	Vet vet2 = new Vet();
	vet2.setFirstName("Jessie");
	vet2.setLastName("Porter");
	vet2.getSpecialities().add(savedSurgery);

	vetService.save(vet2);

	System.out.println("Loading Vets ....");
    }

}
