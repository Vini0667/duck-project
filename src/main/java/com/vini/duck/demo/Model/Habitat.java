package com.vini.duck.demo.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Habitat {
    @Id
    private Long id;

    @NotBlank (message = "O nome deve ser informado")
	@Size (min = 3, message = "O nome deve ter no mínimo 3 caracteres")
    private String name;

    @OneToOne (mappedBy = "habitat", cascade = CascadeType.ALL)
    private Duck duck;
    
    public Habitat(Duck duck) {
        this.duck = duck;
    }

    public Habitat (String name) {
        this.name = name;
    }

    public Habitat () {}

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

    public Duck getDuck() {
        return duck;
    }

    public void setDuck(Duck duck) {
        this.duck = duck;
    }
}
