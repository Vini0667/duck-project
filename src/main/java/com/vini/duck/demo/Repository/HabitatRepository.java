package com.vini.duck.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vini.duck.demo.Model.Habitat;

public interface HabitatRepository extends JpaRepository <Habitat, Long> {
    
}
