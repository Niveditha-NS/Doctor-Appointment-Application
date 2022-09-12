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

import com.doct.doctor.model.Appointment;
import com.doct.doctor.exception.RecordNotFoundException;
import com.doct.doctor.service.AppointmentService;

 
@RestController
@RequestMapping("/appointment")

public class AppointmentController {

	@Autowired
    AppointmentService service;
 
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> list = service.getAllAppointments();
 
        return new ResponseEntity<List<Appointment>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getUserById(@PathVariable("appid") Long appid) 
                                                    throws RecordNotFoundException {
        Appointment entity = service.getAppointmentById(appid);
 
        return new ResponseEntity<Appointment>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
  /* @PostMapping
    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(@RequestBody EmployeeEntity employee)
                                                    throws RecordNotFoundException {
        EmployeeEntity updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.CREATED);
    } */
    
    @RequestMapping(value="/add", method= RequestMethod.POST)
    public ResponseEntity<Appointment> createOrUpdateUser(@RequestBody Appointment employee)
                                                    throws RecordNotFoundException {
        Appointment updated = service.createOrUpdateAppointment(employee);
        return new ResponseEntity<Appointment>(updated, new HttpHeaders(), HttpStatus.CREATED);
    } 
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteAppointmentById(@PathVariable("appid") Long appid) 
                                                    throws RecordNotFoundException {
        service.deleteAppointmentById(appid);
        return HttpStatus.FORBIDDEN;
    }
}
