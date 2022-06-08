package com.javacourse.project.hibernateAndJpa.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javacourse.project.hibernateAndJpa.Entities.City;

//JPA - ORM

@Repository
public class HibernateCityDal implements ICityDal {
	
	private EntityManager manager;
	
	@Autowired
	public HibernateCityDal(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	@Transactional
	public List<City> getAll() {
		Session session=manager.unwrap(Session.class);
		List<City> cities=session.createQuery("from City",City.class).getResultList();
		return cities;
	}

	@Override
	public void add(City city) {
		Session session=manager.unwrap(Session.class);
		session.saveOrUpdate(city);
	}

	@Override
	public void update(City city) {
		Session session=manager.unwrap(Session.class);
		session.saveOrUpdate(city);
	}

	@Override
	public void delete(City city) {
		Session session=manager.unwrap(Session.class);
		City cityToDelete=session.get(City.class, city.getId());
		session.delete(cityToDelete);
		
	}

	@Override
	public City getById(int id) {
		Session session=manager.unwrap(Session.class);
		City city= session.get(City.class, id);
		return city;
	}



}
