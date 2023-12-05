package com.vini.duck.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vini.duck.demo.Model.Habitat;
import com.vini.duck.demo.Repository.HabitatRepository;

@Service
public class HabitatService {
    @Autowired
    private HabitatRepository habitatRepository;

    public Habitat save (Habitat habitat) {
        return habitatRepository.save(habitat);
    }    
}
