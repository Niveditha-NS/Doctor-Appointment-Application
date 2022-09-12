package com.doct.doctor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doct.doctor.model.Patient;
import com.doct.doctor.exception.RecordNotFoundException;
import com.doct.doctor.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
    PatientRepository repository;
     
    public List<Patient> getAllPatients()
    {
        List<Patient> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Patient>();
        }
    }
     
    public Patient getPatientById(Long id) throws RecordNotFoundException 
    {
        Optional<Patient> employee = repository.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
     
    public Patient createOrUpdatePatient(Patient entity) throws RecordNotFoundException 
    {
        Optional<Patient> employee = repository.findById(entity.getId());
         
        if(employee.isPresent()) 
        {
            Patient newEntity = employee.get();
            newEntity.setPEmail(entity.getPEmail());
            newEntity.setPName(entity.getPName());
            newEntity.setPbg(entity.getPbg());
            newEntity.setPmobnum(entity.getPmobnum());
            //newEntity.setLastName(entity.getLastName());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    } 
     
    public void deletePatientById(Long id) throws RecordNotFoundException 
    {
        Optional<Patient> employee = repository.findById(id);
         
        if(employee.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    } 
}
