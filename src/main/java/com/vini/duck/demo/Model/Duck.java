package com.vini.duck.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Duck {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank (message = "O nome deve ser informado")
	@Size (min = 3, message = "O nome deve ter no mínimo 3 caracteres")
	private String name;

	@OneToOne
	private Habitat habitat;

	@ManyToOne
	private ProgrammingLanguages programmingLanguage;

	public Duck () {}

	public Duck(Habitat habitat) {
		this.habitat = habitat;
	}
	
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

	public Habitat getHabitat() {
		return habitat;
	}

	public void setHabitat(Habitat habitat) {
		this.habitat = habitat;
	}

	public ProgrammingLanguages getProgrammingLanguage() {
		return programmingLanguage;
	}

	public void setProgrammingLanguage(ProgrammingLanguages programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}
}
