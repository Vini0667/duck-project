package com.vini.duck.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vini.duck.demo.Model.Duck;

public interface DuckRepository extends JpaRepository <Duck, Long> {
    Optional <Duck> findById (long id);
    List<Duck> findByNameContainingIgnoreCase(String name);
}