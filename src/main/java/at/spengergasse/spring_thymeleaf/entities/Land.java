package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Land {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int einwohner;
    private String hauptstadt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEinwohner() {
        return einwohner;
    }

    public void setEinwohner(int einwohner) {
        this.einwohner = einwohner;
    }

    public String getHauptstadt() {
        return hauptstadt;
    }

    public void setHauptstadt(String hauptstadt) {
        this.hauptstadt = hauptstadt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
