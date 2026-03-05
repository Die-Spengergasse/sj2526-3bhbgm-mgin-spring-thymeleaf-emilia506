package at.spengergasse.spring_thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    @GetMapping("/start")
    public String start() {
        return "start";
        // Startkontroller, man kommt hier hin, wenn man localhost:8080/start eingibt, dann wird die start.html angezeigt
    }
}

