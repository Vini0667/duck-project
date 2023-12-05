package com.vini.duck.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vini.duck.demo.Exception.NotFoundDuckException;
import com.vini.duck.demo.Model.Duck;
import com.vini.duck.demo.Service.DuckService;
// import com.vini.duck.demo.Service.ProgrammingLanguagesService;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class DuckController {
    // @Autowired
    // private ProgrammingLanguagesService programmingLanguagesService;

    @Autowired
    private DuckService duckService;

    @GetMapping ("/")
    public String home (Model model) {
        model.addAttribute("duckList", duckService.findAllDucks());
        return "/home";
    }

    @GetMapping ("/new_duck")
    public String registerPage (Model model) {
        // model.addAttribute("programmingList", programmingLanguagesService.findProgrammingLanguages());
        model.addAttribute("newDuck", new Duck());
        return "/register-duck";
    }

    @PostMapping("/new_duck")
    public String newDuck (@ModelAttribute ("newDuck") @Valid Duck duck, BindingResult errors, RedirectAttributes attr, Model model) {
        if (errors.hasErrors()) {
            // model.addAttribute("programmingList", programmingLanguagesService.findProgrammingLanguages());
            return "/register-duck";
        }
        duckService.save_duck(duck);
        attr.addFlashAttribute("msg", "Pato salvo com sucesso");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteDuck (@PathVariable("id") long id) {
        try {
            duckService.removeDuckById(id);
        } catch (NotFoundDuckException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editDuck (@PathVariable("id") long id, RedirectAttributes rtt, Model model) {
        try {
            // model.addAttribute("programmingList", programmingLanguagesService.findProgrammingLanguages());
            model.addAttribute("editDuck", duckService.findDuckById(id));
            return "/edit-duck";
        } catch (NotFoundDuckException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String editDuck (@PathVariable("id") long id, @ModelAttribute ("editDuck") @Valid Duck duck, BindingResult errors, RedirectAttributes attr, Model model) {
        duck.setId(id);
        if (errors.hasErrors()) {
            model.addAttribute("editDuck", duck);
            // model.addAttribute("programmingList", programmingLanguagesService.findProgrammingLanguages());
            return "/edit-duck";
        }
        
        duckService.edit_duck(duck);
        return "redirect:/";
    }

    @PostMapping("/find")
    public String findDucks (@RequestParam("a") String name, Model model) {
        if (name == null) {
            return "redirect:/";
        }
        model.addAttribute("duckList", duckService.findDucksByName(name));
        return "/home";
    }
}
