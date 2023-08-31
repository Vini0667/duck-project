package com.vini.duck.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Duck {
	private final int MIN_CHARACTERS = 3;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank (message = "O nome deve ser informado")
	@Size (min = MIN_CHARACTERS, message = "O nome deve ter no mínimo " + MIN_CHARACTERS + " caracteres")
	private String name;

	private String programmingLanguage;

	public Long getId () {
		return this.id;
	}

	public void setId (Long id) {
		this.id = id;
	}

	public String getName () {
		return this.name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public String getProgrammingLanguage () {
		return this.programmingLanguage;
	}

	public void setProgrammingLanguage (String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}
}
