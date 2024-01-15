package org.example.demo.stream.api.controller;

import lombok.AllArgsConstructor;
import org.example.demo.stream.api.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class PersonController {
    @Autowired
    private PersonDAO personDAO;

    @GetMapping("/")
    public String getHome() {
        return "index";
    }

    @GetMapping("/getAll")
    public String getAll(Model model) {
        model.addAttribute("people", personDAO.getAll());
        return "getAll";
    }

    @GetMapping("/sortPeopleByFullName")
    public String sortPeopleByFullName() {
        return "sortPeopleByFullName";
    }
}
