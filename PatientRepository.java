package com.medical.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.management.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
