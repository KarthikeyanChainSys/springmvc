package com.chainsys.springmvc.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chainsys.springmvc.dao.AppointmentRepository;
import com.chainsys.springmvc.dao.DoctorRepository;
import com.chainsys.springmvc.pojo.Appointment;
import com.chainsys.springmvc.pojo.DoctorAppointmentsDTO;
import com.chainsys.springmvc.pojo.Doctors;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepository repo;
	@Autowired
	private AppointmentRepository apprepo; 
	public List<Doctors> getDoctors(){
		List<Doctors> listDr = repo.findAll();
		return listDr;
	}
	
	public Doctors save(Doctors dr) {
		return repo.save(dr);
	}
	
	public Doctors findById(int id) {
		return repo.findById(id);
	}
	
	public void deleteById(int id) {
		repo.deleteById(id);
	}
	
	public DoctorAppointmentsDTO getDoctorAndAppointments(int id) {
		Doctors dr = findById(id);
		DoctorAppointmentsDTO dto = new DoctorAppointmentsDTO();
		dto.setDoctor(dr);
		for(int i=0; i<=5; i++) {
			Appointment app = new Appointment();
			app.setApp_id(i);
			Date dt= new Date(22,7,25);
			app.setApp_date(dt);
			app.setDoc_id(id);
			app.setPatient_name("Raja");
			app.setFees_collected(i*500);
			dto.addAppointment(app);
		}
		return dto;
	}

	public void addDoctorAndAppointments(DoctorAppointmentsDTO dto) {
		Doctors dr = dto.getDoctor();
		save(dr);
		List<Appointment> appList = dto.getAppointments();
		int count = appList.size();
		for(int i=0; i<count; i++) {
			apprepo.save(appList.get(i)); // save doctor and appointment values in at a time
		}
	}
}
