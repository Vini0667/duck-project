package com.vini.duck.demo.Model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import java.util.List;

@Entity
public class ProgrammingLanguages {
    @Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "O nome deve ser informado")
    private String name;

    @OneToMany(mappedBy = "programmingLanguage")
    private List<Duck> ducks;

    public ProgrammingLanguages (String name) {
        this.name = name;
    }

    public ProgrammingLanguages() {}    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Duck> getDucks() {
        return ducks;
    }

    public void setDucks(List<Duck> ducks) {
        this.ducks = ducks;
    }
}
