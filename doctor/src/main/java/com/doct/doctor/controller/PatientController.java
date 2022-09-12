package com.doct.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doct.doctor.model.Patient;
import com.doct.doctor.exception.RecordNotFoundException;
import com.doct.doctor.service.PatientService;

 
@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
    PatientService service;
 
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> list = service.getAllPatients();
 
        return new ResponseEntity<List<Patient>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("pid") Long pid) 
                                                    throws RecordNotFoundException {
        Patient entity = service.getPatientById(pid);
 
        return new ResponseEntity<Patient>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
  /* @PostMapping
    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(@RequestBody EmployeeEntity employee)
                                                    throws RecordNotFoundException {
        EmployeeEntity updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.CREATED);
    } */
    
    @RequestMapping(value="/add", method= RequestMethod.POST)
    public ResponseEntity<Patient> createOrUpdatePatient(@RequestBody Patient employee)
                                                    throws RecordNotFoundException {
        Patient updated = service.createOrUpdatePatient(employee);
        return new ResponseEntity<Patient>(updated, new HttpHeaders(), HttpStatus.CREATED);
    } 
 
    @DeleteMapping("/{id}")
    public HttpStatus deletePatientById(@PathVariable("pid") Long pid) 
                                                    throws RecordNotFoundException {
        service.deletePatientById(pid);
        return HttpStatus.FORBIDDEN;
    }
 
}
