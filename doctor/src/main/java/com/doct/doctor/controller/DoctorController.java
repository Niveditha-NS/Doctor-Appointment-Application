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

import com.doct.doctor.model.Doctor;
import com.doct.doctor.exception.RecordNotFoundException;
import com.doct.doctor.service.DoctorService;

 
@RestController
@RequestMapping("/doctor")

public class DoctorController {

	@Autowired
    DoctorService service;
 
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> list = service.getAllDoctors();
 
        return new ResponseEntity<List<Doctor>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("did") Long did) 
                                                    throws RecordNotFoundException {
        Doctor entity = service.getDoctorById(did);
 
        return new ResponseEntity<Doctor>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
  /* @PostMapping
    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(@RequestBody EmployeeEntity employee)
                                                    throws RecordNotFoundException {
        EmployeeEntity updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.CREATED);
    } */
    
    @RequestMapping(value="/add", method= RequestMethod.POST)
    public ResponseEntity<Doctor> createOrUpdateDoctor(@RequestBody Doctor employee)
                                                    throws RecordNotFoundException {
        Doctor updated = service.createOrUpdateDoctor(employee);
        return new ResponseEntity<Doctor>(updated, new HttpHeaders(), HttpStatus.CREATED);
    } 
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteDoctorById(@PathVariable("did") Long did) 
                                                    throws RecordNotFoundException {
        service.deleteDoctorById(did);
        return HttpStatus.FORBIDDEN;
    }
}
