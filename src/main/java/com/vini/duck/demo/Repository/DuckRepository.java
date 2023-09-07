package com.vini.duck.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vini.duck.demo.Model.Duck;

public interface DuckRepository extends JpaRepository <Duck, Long> {

}