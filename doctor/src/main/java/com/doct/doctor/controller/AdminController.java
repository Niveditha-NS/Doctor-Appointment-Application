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
 
import com.doct.doctor.model.Admin;
import com.doct.doctor.exception.RecordNotFoundException;
import com.doct.doctor.service.AdminService;

 
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
    AdminService service;
 
    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> list = service.getAllAdmins();
 
        return new ResponseEntity<List<Admin>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable("id") Long id) 
                                                    throws RecordNotFoundException {
        Admin entity = service.getAdminById(id);
 
        return new ResponseEntity<Admin>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
  /* @PostMapping
    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(@RequestBody EmployeeEntity employee)
                                                    throws RecordNotFoundException {
        EmployeeEntity updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.CREATED);
    } */
    
    @RequestMapping(value="/add", method= RequestMethod.POST)
    public ResponseEntity<Admin> createOrUpdateAdmin(@RequestBody Admin employee)
                                                    throws RecordNotFoundException {
        Admin updated = service.createOrUpdateAdmin(employee);
        return new ResponseEntity<Admin>(updated, new HttpHeaders(), HttpStatus.CREATED);
    } 
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteAdminById(@PathVariable("id") Long id) 
                                                    throws RecordNotFoundException {
        service.deleteAdminById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}
