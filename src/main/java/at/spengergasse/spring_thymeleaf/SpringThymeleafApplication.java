package at.spengergasse.spring_thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //es wird automatisch ein webserver gestartet und macht eine instanz von spring thymeleaf application
// findet aber nur klassen die in einem package sind, das unterhalb von at.spengergasse.spring_thymeleaf liegt
//schaut alle klassen durch und schaut ob eine anoation vorhanden ist
public class SpringThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringThymeleafApplication.class, args);
    }

}
