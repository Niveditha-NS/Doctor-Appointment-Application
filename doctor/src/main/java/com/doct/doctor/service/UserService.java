package com.doct.doctor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doct.doctor.model.User;
import com.doct.doctor.exception.RecordNotFoundException;
import com.doct.doctor.repository.UserRepository;

@Service
public class UserService {

	@Autowired
    UserRepository repository;
     
    public List<User> getAllUsers()
    {
        List<User> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<User>();
        }
    }
     
    public User getUserById(Long id) throws RecordNotFoundException 
    {
        Optional<User> employee = repository.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
     
    public User createOrUpdateUser(User entity) throws RecordNotFoundException 
    {
        Optional<User> employee = repository.findById(entity.getId());
         
        if(employee.isPresent()) 
        {
            User newEntity = employee.get();
            newEntity.setUName(entity.getUName());
            newEntity.setPassword(entity.getPassword());
            newEntity.setRole(entity.getRole());
            //newEntity.setDmobnum(entity.getDmobnum());
            //newEntity.setLastName(entity.getLastName());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    } 
     
    public void deleteUserById(Long id) throws RecordNotFoundException 
    {
        Optional<User> employee = repository.findById(id);
         
        if(employee.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    } 
}
