package com.oliveiralucaspro.sfgpetclinic.controllers;

import java.util.Set;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oliveiralucaspro.sfgpetclinic.model.Vet;
import com.oliveiralucaspro.sfgpetclinic.services.VetService;

@RestController
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
	this.vetService = vetService;
    }

    @GetMapping({ "/vets", "/vets/index", "/vets/index.html", "/index.html", "/vets.html" })
    public String listVets(Model model) {

	model.addAttribute("vets", vetService.findAll());

	return "vets/index";
    }

    @GetMapping("/api/vets")
    public @ResponseBody Set<Vet> getVetsJson() {
	return vetService.findAll();
    }

}
