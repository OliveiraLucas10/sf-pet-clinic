package com.oliveiralucaspro.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.oliveiralucaspro.sfgpetclinic.model.Specialty;
import com.oliveiralucaspro.sfgpetclinic.model.Vet;
import com.oliveiralucaspro.sfgpetclinic.services.SpecialtyService;
import com.oliveiralucaspro.sfgpetclinic.services.VetService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyMapService;

    @Override
    public Set<Vet> findAll() {
	return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
	return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
	if (object.getSpecialities().size() > 0) {
	    object.getSpecialities().forEach(specialty -> {
		if (specialty.getId() == null) {
		    Specialty savedSpeciality = specialtyMapService.save(specialty);
		    specialty.setId(savedSpeciality.getId());
		}
	    });
	}

	return super.save(object);
    }

    @Override
    public void delete(Vet object) {
	super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
	super.deleteById(id);
    }

}
