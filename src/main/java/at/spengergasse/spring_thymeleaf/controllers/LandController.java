package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.Land;
import at.spengergasse.spring_thymeleaf.entities.LandRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/land")
public class LandController {
    private final LandRepository landRepository;
    // Repository speichert die Daten, damit sie auch nach einem Neustart der Anwendung noch da sind, weil es in einer Datenbank gespeichert wird
// hier kommt man von der Startseite auf die Landseite, damit man die Länder sehen kann, die in der Datenbank gespeichert sind
    public LandController(LandRepository landRepository) {
        this.landRepository = landRepository;
        // jetzt weiter zu liste und add

    }
    @GetMapping("/list")
    public String landList(Model model) {
        model.addAttribute("lands", landRepository.findAll());
        return "landlist";
        //hier wird aus dem repository alle länder in eine liste aufgerufen und auf landlist template verwiesen
    }
    @GetMapping("/add")
    public String addLand(Model model) {
        model.addAttribute("land", new Land());
        return "add_land";
        // hier wird ein neues land erstellt und auf add_land template verwiesen
    }
    @PostMapping("/add")
    public String addLand(@ModelAttribute("land") Land land) {
        landRepository.save(land);
        return "redirect:/land/list";
        // hier wird das land in die datenbank gespeichert, nachdem es eingegeben wurde, und danach wird man wieder zur liste weitergeleitet
    }
    @GetMapping("/delete")
    public String deleteLand(@RequestParam Integer id) {
        landRepository.deleteById(id);
        return "delete_land";
        // hier wird das land aus der datenbank gelöscht, und danach wird man auf delete_land template weitergeleitet, und über RequestParam wird die id des landes übergeben, damit es gelöscht werden kann
    }
    @GetMapping("/bearbeiten/{id}")
    public String bearbeiten(Model model, @PathVariable Integer id) {
        Land land = landRepository.findById(id).orElseThrow();
        model.addAttribute("land", land);
        return "add_land";
        // hier wird das land aus der datenbank geholt, und danach wird es in das add_land template übergeben, damit man es bearbeiten kann, und über PathVariable wird die id des landes übergeben, damit es weiß welches
    }
}

