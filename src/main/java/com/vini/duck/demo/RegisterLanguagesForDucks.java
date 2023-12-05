// package com.vini.duck.demo;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// import com.vini.duck.demo.Model.ProgrammingLanguages;
// import com.vini.duck.demo.Repository.ProgrammingLanguagesRepository;

// @Component
// public class RegisterLanguagesForDucks implements CommandLineRunner {
//     @Autowired
//     private ProgrammingLanguagesRepository programmingLanguagesRepository;
    
//     @Override
//     public void run (String ...args) throws Exception {
//         String[] initialLanguangeNames = {"JavaScript", "Java", "C", "Python", "Ruby", "PHP", "Rust", "C++", "C#", "Go"};

//         for (String language : initialLanguangeNames) {
//             ProgrammingLanguages programmingLanguage = programmingLanguagesRepository.findByName(language);
//             if (programmingLanguage == null) {
//                 ProgrammingLanguages newLanguage = new ProgrammingLanguages(language);
//                 programmingLanguagesRepository.save(newLanguage);
//             }
//         }
//     }
// }
