package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.Land;
import at.spengergasse.spring_thymeleaf.entities.LandRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping ("/add")
    public String addLand(Model model) {
        model.addAttribute("land", new Land());
        return "add_land";

    }

    @PostMapping ("/add")
    public String addLand(@ModelAttribute("land") Land land) {
        landRepository.save(land);
        return "redirect:/land/list";
    }

    @GetMapping ("/edit")
    public String editLand(@RequestParam("id") Integer id, Model model) {
        Land land = landRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid land Id:" + id));
        model.addAttribute("land", land);
        return "edit_land";
    }

}
