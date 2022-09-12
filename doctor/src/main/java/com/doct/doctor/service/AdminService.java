package com.doct.doctor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.doct.doctor.model.Admin;
import com.doct.doctor.exception.RecordNotFoundException;
import com.doct.doctor.repository.AdminRepository;


@Service
public class AdminService {

	@Autowired
    AdminRepository repository;
     
    public List<Admin> getAllAdmins()
    {
        List<Admin> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Admin>();
        }
    }
     
    public Admin getAdminById(Long id) throws RecordNotFoundException 
    {
        Optional<Admin> employee = repository.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
     
    public Admin createOrUpdateAdmin(Admin entity) throws RecordNotFoundException 
    {
        Optional<Admin> employee = repository.findById(entity.getId());
         
        if(employee.isPresent()) 
        {
            Admin newEntity = employee.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setName(entity.getName());
            //newEntity.setLastName(entity.getLastName());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    } 
     
    public void deleteAdminById(Long id) throws RecordNotFoundException 
    {
        Optional<Admin> employee = repository.findById(id);
         
        if(employee.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    } 
}
