package com.vini.duck.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vini.duck.demo.Repository.DuckRepository;
import com.vini.duck.demo.Exception.NotFoundDuckException;
import com.vini.duck.demo.Model.Duck;

@Service
public class DuckService {
	@Autowired
	private DuckRepository duckRepository;

	public Duck save_duck (Duck duck) {
		return duckRepository.save(duck);
	}

	public List<Duck> findAllDucks () {
		return duckRepository.findAll();
	}

	public Duck findDuckById (long id) throws NotFoundDuckException {
		Optional<Duck> dk = duckRepository.findById(id);
		if (dk.isPresent()) {
			return dk.get();
		} else {
			throw new NotFoundDuckException("Pato com o id" + id + " não foi encontrado");
		}
	}

	public void removeDuckById (long id) throws NotFoundDuckException {
		duckRepository.delete(this.findDuckById(id));
	}

	public Duck edit_duck (Duck duck) {
		return duckRepository.save(duck);
	}

	public List<Duck> findDucksByName (String name) {
		return duckRepository.findByNameContainingIgnoreCase(name);
	}
}