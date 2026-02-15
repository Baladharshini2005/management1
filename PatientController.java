package com.medical.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.medical.management.repository.PatientRepository;
import com.medical.management.model.Patient;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository repo;

    @GetMapping("/all-patients")
    public String showPatients(Model model) {
        model.addAttribute("patients", repo.findAll());
        return "patient-list"; 
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "add-patients";
    }

   
    @PostMapping("/save")
    public String savePatient(@ModelAttribute("patient") Patient patient) {
        repo.save(patient);
        return "redirect:/patient/all-patients";
    }
}


