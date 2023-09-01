package com.vini.duck.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepoistory;
import com.vini.duck.demo.Model.Duck;

public interface DuckRepository extends JpaRepoistory <Duck, Long> {

}