package com.vini.duck.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vini.duck.demo.Model.Duck;
import com.vini.duck.demo.Service.DuckService;
import com.vini.duck.demo.Service.ProgrammingLanguagesService;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class DuckController {
    @Autowired
    private ProgrammingLanguagesService programmingLanguagesService;

    @Autowired
    private DuckService duckService;

    @GetMapping ("/")
    public String home () {
        return "/home";
    }

    @GetMapping ("/new_duck")
    public String registerPage (Model model) {
        model.addAttribute("programmingList", programmingLanguagesService.findProgrammingLanguages());
        model.addAttribute("newDuck", new Duck());
        return "/register-duck";
    }

    @PostMapping("/new_duck")
    public String newDuck (@ModelAttribute ("newDuck") @Valid Duck duck, BindingResult errors, RedirectAttributes attr, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("programmingList", programmingLanguagesService.findProgrammingLanguages());
            return "/register-duck";
        }
        duckService.save_duck(duck);
        attr.addFlashAttribute("msg", "Pato salvo com sucesso");
        return "redirect:/";
    }
}
