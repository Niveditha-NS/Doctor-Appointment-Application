package com.doct.doctor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doct.doctor.model.Appointment;
import com.doct.doctor.model.User;
import com.doct.doctor.exception.RecordNotFoundException;
import com.doct.doctor.repository.AppointmentRepository;
import com.doct.doctor.repository.UserRepository;

@Service
public class AppointmentService {

	@Autowired
    AppointmentRepository repository;
     
    public List<Appointment> getAllAppointments()
    {
        List<Appointment> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Appointment>();
        }
    }
     
    public Appointment getAppointmentById(Long id) throws RecordNotFoundException 
    {
        Optional<Appointment> employee = repository.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
     
    public Appointment createOrUpdateAppointment(Appointment entity) throws RecordNotFoundException 
    {
        Optional<Appointment> employee = repository.findById(entity.getId());
         
        if(employee.isPresent()) 
        {
            Appointment newEntity = employee.get();
            newEntity.setPatientName(entity.getPatientName());
            newEntity.setDoctorName(entity.getDoctorName());
            newEntity.setDate(entity.getDate());
            //newEntity.setDmobnum(entity.getDmobnum());
            //newEntity.setLastName(entity.getLastName());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    } 
     
    public void deleteAppointmentById(Long id) throws RecordNotFoundException 
    {
        Optional<Appointment> employee = repository.findById(id);
         
        if(employee.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    } 
}
