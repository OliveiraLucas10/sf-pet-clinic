package com.oliveiralucaspro.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("owners")
@Controller
public class OwnerController {

    @RequestMapping({ "", "/", "/index", "/intex.html" })
    public String listOwners() {

	return "owners/index";
    }

}
