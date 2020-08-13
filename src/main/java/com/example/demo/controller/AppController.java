package com.example.demo.controller;

import com.example.demo.repository.EmploieRepository;
import com.example.demo.repository.GroupeRepository;
import com.example.demo.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Autowired
    private GroupeRepository groupeRepository;

    @Autowired
    private SalleRepository salleRepository;

    @GetMapping("/")
    public String showSignUpForm(Model model) {

        model.addAttribute("groupeList", groupeRepository.findAll());
        model.addAttribute("salleList", salleRepository.findAll());

        return "index";
    }

}
