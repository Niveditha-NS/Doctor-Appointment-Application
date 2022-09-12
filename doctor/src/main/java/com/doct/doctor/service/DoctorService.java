package com.doct.doctor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doct.doctor.model.Doctor;
import com.doct.doctor.exception.RecordNotFoundException;
import com.doct.doctor.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
    DoctorRepository repository;
     
    public List<Doctor> getAllDoctors()
    {
        List<Doctor> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Doctor>();
        }
    }
     
    public Doctor getDoctorById(Long id) throws RecordNotFoundException 
    {
        Optional<Doctor> employee = repository.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
     
    public Doctor createOrUpdateDoctor(Doctor entity) throws RecordNotFoundException 
    {
        Optional<Doctor> employee = repository.findById(entity.getId());
         
        if(employee.isPresent()) 
        {
            Doctor newEntity = employee.get();
            newEntity.setDEmail(entity.getDEmail());
            newEntity.setDName(entity.getDName());
            newEntity.setHName(entity.getHName());
            newEntity.setDmobnum(entity.getDmobnum());
            //newEntity.setLastName(entity.getLastName());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    } 
     
    public void deleteDoctorById(Long id) throws RecordNotFoundException 
    {
        Optional<Doctor> employee = repository.findById(id);
         
        if(employee.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    } 
}
