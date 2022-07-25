package com.chainsys.springmvc.pojo;

import java.util.ArrayList;
import java.util.List;

public class DoctorAppointmentsDTO {
	private Doctors doctor;
	private List<Appointment> applist = new ArrayList<Appointment>();
	public Doctors getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctors doctor) {
		this.doctor = doctor;
	}
	public void addAppointment(Appointment app) {
		applist.add(app);
	}
	public List<Appointment> getAppointments(){
		return applist;
	}
}
