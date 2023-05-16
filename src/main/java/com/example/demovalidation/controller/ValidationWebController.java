package com.example.demovalidation.controller;

import com.example.demovalidation.Dto.CreateUserDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ValidationWebController {


    @GetMapping("users/add")
    public String displayForm(Model model) {
        model.addAttribute("user", new CreateUserDto());
        return "user-form";
    }


    @PostMapping("users/add")
    public String add(@Valid @ModelAttribute("user") CreateUserDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user-form";
        }
        // Ajouter l'utilisateur grace au service....
        // Rediriger vers la page de notre choix
        return "home";
    }
}