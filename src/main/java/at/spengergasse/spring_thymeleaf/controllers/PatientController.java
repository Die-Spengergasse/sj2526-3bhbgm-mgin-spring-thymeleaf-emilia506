package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.Patient;
import at.spengergasse.spring_thymeleaf.entities.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.format.DateTimeFormatter;
//anotation, damit spring weiß, dass es sich um einen controller handelt, der die anfragen bearbeitet
//hat eine refernez drauf, damit er die patienten in der datenbank speichern kann, damit er sie in der liste anzeigen kann
//man schreibt im kontruktor, bitte übergib mir das patient repository
//es wird eine instanz erstellt, findet den controller und gibt eine refernz auf das repository
//find all sucht alle patienten der datenbank und gibt sie zurück, damit sie in der liste angezeigt werden können
//add fügt einen neuen patienten hinzu, der über das formular übergeben wird, speichert ihn in der datenbank und leitet zurück zur liste weiter

//schaut was man in dem link eingibt und schaut dann welche methode dazu passt
@Controller
@RequestMapping("/patient")
public class PatientController {
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/list")
    public String patients(Model model) {
        model.addAttribute("patients", patientRepository.findAll());
        return "patlist";
    }

    @GetMapping("/add")
    public String addPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "add_patient";
    }

    @PostMapping("/add")
    public String addPatient(@ModelAttribute("patient") Patient patient) {
        patientRepository.save(patient);
        return  "redirect:/patient/list";
    }

}
