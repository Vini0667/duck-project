package com.vini.duck.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vini.duck.demo.Exception.NotFoundDuckException;
import com.vini.duck.demo.Model.Duck;
import com.vini.duck.demo.Model.Habitat;
import com.vini.duck.demo.Service.DuckService;
import com.vini.duck.demo.Service.HabitatService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/habitat")
public class HabitatController {
    @Autowired
    private HabitatService habitatService;

    @Autowired
    private DuckService duckService;

    @GetMapping("/findHabitat/{id}")
    public String findHabitat (@PathVariable("id") long id, Model model) {
        try {
            Duck dk = duckService.findDuckById(id);
            if (dk.getHabitat() == null) {
                model.addAttribute("habitat", new Habitat(dk));
                return "/register-habitat";
            } else {
                model.addAttribute("habitat", dk.getHabitat());
                return "/edit-habitat";
            }
        } catch (NotFoundDuckException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @PostMapping("/save/{id}")
    public String saveHabitat(@PathVariable("id") long id, @ModelAttribute("habitat") @Valid Habitat habitat, BindingResult result, RedirectAttributes ra, Model model) {
        try {
            Duck dk = duckService.findDuckById(id);
            habitat.setDuck(dk);
            if (dk == null || result.hasErrors()) {
                model.addAttribute("habitat", new Habitat());
                return "/register-habitat";
            } else {
                dk.setHabitat(habitat);
                habitatService.save(habitat);
                return "redirect:/";
            }
        } catch (NotFoundDuckException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
    
}
