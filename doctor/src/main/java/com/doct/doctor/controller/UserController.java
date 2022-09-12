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

import com.doct.doctor.model.User;
import com.doct.doctor.exception.RecordNotFoundException;
import com.doct.doctor.service.UserService;

 
@RestController
@RequestMapping("/userstb")

public class UserController {

	@Autowired
    UserService service;
 
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = service.getAllUsers();
 
        return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("usersid") Long usersid) 
                                                    throws RecordNotFoundException {
        User entity = service.getUserById(usersid);
 
        return new ResponseEntity<User>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
  /* @PostMapping
    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(@RequestBody EmployeeEntity employee)
                                                    throws RecordNotFoundException {
        EmployeeEntity updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.CREATED);
    } */
    
    @RequestMapping(value="/add", method= RequestMethod.POST)
    public ResponseEntity<User> createOrUpdateUser(@RequestBody User employee)
                                                    throws RecordNotFoundException {
        User updated = service.createOrUpdateUser(employee);
        return new ResponseEntity<User>(updated, new HttpHeaders(), HttpStatus.CREATED);
    } 
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteUserById(@PathVariable("usersid") Long usersid) 
                                                    throws RecordNotFoundException {
        service.deleteUserById(usersid);
        return HttpStatus.FORBIDDEN;
    }
}
