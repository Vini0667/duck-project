package com.vini.duck.demo.Model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import java.util.List;

import com.vini.duck.demo.Model.Duck;

@Entity
public class ProgrammingLanguages {
    private final int MIN_CHARACTERS = 3;
    @Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "O nome deve ser informado")
	@Size (min = MIN_CHARACTERS, message = "O nome deve ter no mínimo " + MIN_CHARACTERS + " caracteres")
    private String name;

	@ManyToMany(mappedBy = "programmingLanguages")
    private List<Duck> ducks;
}
