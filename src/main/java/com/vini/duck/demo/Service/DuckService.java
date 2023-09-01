package com.vini.duck.demo.Service.DuckService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vini.duck.demo.Service.Repository.DuckRepository;
import com.vini.duck.demo.Model.Duck;

@Service
public class DuckService {
	@Autowired
	private DuckRepository duckRepository;

	public Duck save_duck (Duck duck) {
		return duckRepository.save(duck);
	}
}