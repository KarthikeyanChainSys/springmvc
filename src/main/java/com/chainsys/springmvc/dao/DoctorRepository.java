package com.chainsys.springmvc.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.chainsys.springmvc.pojo.Doctors;

public interface DoctorRepository extends CrudRepository<Doctors,Integer> {
	Doctors findById(int id);
	Doctors save(Doctors theDoc);
	// Used for adding new doctor
	void deleteById(int id);
	List<Doctors> findAll();
}