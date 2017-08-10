package com.endava.demo.Controllers;

import com.endava.demo.PersonForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

    @GetMapping("/")
    public String student(Model model) {
        PersonForm personForm = new PersonForm();
        model.addAttribute("personForm", personForm);
        return "form";
    }

    @PostMapping("/")
    public String addStudent(@ModelAttribute("personForm") @Valid PersonForm person, BindingResult bindingResult, Model model) {

        model.addAttribute("name", person.getName());
        model.addAttribute("age", person.getAge());

        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/results";
    }

    @GetMapping("/results")
    public String results(@ModelAttribute("personForm") PersonForm person, BindingResult bindingResult, Model model) {

        model.addAttribute("name", person.getName());
        model.addAttribute("age", person.getAge());

        return "results";
    }



}