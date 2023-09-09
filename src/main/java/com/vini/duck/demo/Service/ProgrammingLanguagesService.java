package com.vini.duck.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vini.duck.demo.Model.ProgrammingLanguages;
import com.vini.duck.demo.Repository.ProgrammingLanguagesRepository;

@Service
public class ProgrammingLanguagesService {
    @Autowired
    private ProgrammingLanguagesRepository programmingLanguagesRepository;
    
    public List <ProgrammingLanguages> findProgrammingLanguages () {
        return programmingLanguagesRepository.findAll();
    } 
}
