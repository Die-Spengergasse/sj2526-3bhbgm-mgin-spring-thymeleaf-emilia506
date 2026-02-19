package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.LandRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/land")
public class LandController {
    private final LandRepository landRepository;

    public LandController(LandRepository landRepository) {
        this.landRepository = landRepository;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("lands", landRepository.findAll());
        return "landlist";
    }

}
