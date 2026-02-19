package at.spengergasse.spring_thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//wird automatisch geladen und hat keine abhängigkeiten
//get mapping heißt welche methode wird da jz aufgerufen
//ohne nichts hinten kommt genau diese methode dran
//bekommt vom framework ein model übergeben, dh

//schaut nur, dass datum da steht, wenn nicht weiter hinten steht
@Controller
public class HelloController {

    @GetMapping("")
    public  String index(Model model) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        model.addAttribute("today", LocalDate.now().format(dtf));
        return "index";
    }
}
