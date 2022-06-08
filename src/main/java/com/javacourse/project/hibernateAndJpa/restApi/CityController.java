package com.javacourse.project.hibernateAndJpa.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacourse.project.hibernateAndJpa.Business.ICityService;
import com.javacourse.project.hibernateAndJpa.Entities.City;

@RestController
@RequestMapping("/api")
public class CityController {
	private ICityService service;
	
	@Autowired
	public CityController(ICityService service) {
		this.service = service;
	}
	
	@GetMapping("/cities")
	public List<City> get(){
		return service.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody City city) {
		service.add(city);
	}
	@PostMapping("/update")
	public void update(@RequestBody City city) {
		service.update(city);
	}
	@PostMapping("/delete")
	public void delete(@RequestBody City city) {
		service.delete(city);
	}
	@GetMapping("/cities/{id}")
	public City getById(@PathVariable int id){
		return service.getById(id);
	}


	
}
