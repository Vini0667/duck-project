package com.vini.duck.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vini.duck.demo.Model.ProgrammingLanguages;
import com.vini.duck.demo.Service.ProgrammingLanguagesService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/language")
public class ProgrammingLanguageController {
    @Autowired
    private ProgrammingLanguagesService programmingLanguagesService;

    @GetMapping("/new")
    public String findProgrammingLanguage(Model model) {
        model.addAttribute("language", new ProgrammingLanguages());
        return "/register-language";
    }
    
    @PostMapping("/new")
    public String saveLanguage(@ModelAttribute("language") @Valid ProgrammingLanguages pg, BindingResult error, RedirectAttributes att, Model model) {
        if (error.hasErrors()) {
            model.addAttribute("language", new ProgrammingLanguages());
            return "/register-language";
        }
        programmingLanguagesService.save(pg);
        return "redirect:/";
    }
    
}