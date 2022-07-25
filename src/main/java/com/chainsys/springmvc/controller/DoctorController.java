package com.chainsys.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.springmvc.pojo.Appointment;
import com.chainsys.springmvc.pojo.DoctorAppointmentsDTO;
import com.chainsys.springmvc.pojo.Doctors;
import com.chainsys.springmvc.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	DoctorService drservice;

	@GetMapping("/finddoctorbyid")
	public String findDoctorById(@RequestParam("docid") int id, Model model) {
		Doctors theDoc = drservice.findById(id);
		model.addAttribute("finddoctorbyid", theDoc);
		return "find-doctor-id-form";
	}
	
	@GetMapping("/addform")
	public String showAddForm(Model model) {
		Doctors theDoc = new Doctors();
		model.addAttribute("adddoctor", theDoc);
		return "add-doctor-form";
	}
	
	@PostMapping("/add")
	// We need give from where to read data from the HTTP request and also the content type ("application/json")
	public String addNewDoctor(@ModelAttribute("adddoctor") Doctors theDoc) {
		drservice.save(theDoc);
		return "redirect:/doctor/list";
	}
	
	@GetMapping("/updateform")
	public String showUpdateForm(@RequestParam("docid") int id, Model model) {
		Doctors theDoc = drservice.findById(id);
		model.addAttribute("updatedoctor", theDoc);
		return "update-doctor-form";
	}
	
	@PostMapping("/updatedoc")
	public String UpdateDoctors(@ModelAttribute("updatedoctor") Doctors theDoc)
	{
	 drservice.save(theDoc);
	 return "redirect:/doctor/list";
	 
	}
	
	@GetMapping("/list")
	public String getDoctors(Model model) {
		List<Doctors> theDoc = drservice.getDoctors();
		model.addAttribute("alldoctor", theDoc);
		return "list-doctors";
	}
	
	@GetMapping("/deletedoctor")
	public String deleteDoctors(@RequestParam("docid") int id) {
		drservice.deleteById(id);
		return "redirect:/doctor/list";
	}
	
	@GetMapping("/getdocapp")
	public String getAppointments(@RequestParam("id") int id, Model model) {
		DoctorAppointmentsDTO dto = drservice.getDoctorAndAppointments(id);
		model.addAttribute("getdoc", dto.getDoctor());
		model.addAttribute("applist", dto.getAppointments());
		return "list-doctor-appointments";
	}
	
	@GetMapping("/trans")
	public void testTransaction(@RequestParam("id") int id) {
		DoctorAppointmentsDTO dto = new DoctorAppointmentsDTO();
		Doctors dr = new Doctors();
		dr.setDoc_id(id);
		dr.setDoc_name("Beerus");
		dr.setCity("Universe 12");
		Date drdob= new Date(23,03,19);
		dr.setDob(drdob);
		dr.setPhone_no(7898765678L);
		dr.setSpeciality("General");
		dr.setStandard_fees(800);
		dto.setDoctor(dr);
		List<Appointment> applist = new ArrayList<Appointment>();
		for(int i=4; i<=8; i++) {
			Appointment app = new Appointment();
			app.setApp_id(i);
			Date appdob= new Date(22,7,25);
			app.setApp_date(appdob);
			app.setDoc_id(id);
			app.setPatient_name("karthi");
			app.setFees_collected(i*500);
			app.setFees_catogory("medium");
			dto.addAppointment(app);
		}
		drservice.addDoctorAndAppointments(dto);
		System.out.println("Successfully completed");
	}
}