package com.vini.duck.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import jakarta.persistence.ManyToMany;

@Entity
public class Duck {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank (message = "O nome deve ser informado")
	@Size (min = 3, message = "O nome deve ter no mínimo 3 caracteres")
	private String name;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable (name = "duck_languages", joinColumns = @JoinColumn(name = "duck_id"), inverseJoinColumns = @JoinColumn(name = "programming_languages_id"))
	private List<ProgrammingLanguages> programmingLanguages;

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

	public List<ProgrammingLanguages> getProgrammingLanguages() {
		return programmingLanguages;
	}

	public void setProgrammingLanguages(List<ProgrammingLanguages> programmingLanguages) {
		this.programmingLanguages = programmingLanguages;
	}
}
