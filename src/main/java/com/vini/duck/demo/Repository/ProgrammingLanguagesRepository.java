package com.vini.duck.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vini.duck.demo.Model.ProgrammingLanguages;

public interface ProgrammingLanguagesRepository extends JpaRepository <ProgrammingLanguages, Long> {
    
}
