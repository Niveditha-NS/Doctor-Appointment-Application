package com.doct.doctor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="appointment")
public class Appointment {

	@Id
    @GeneratedValue
    @Column(name="appid")
    private Long appid;
     
    @Column(name="patientname")
    private String patientname;
     
    @Column(name ="doctorname")
    private String doctorname;
    
    @Column(name ="appdate")
    private String adate;
     
   /* @Column(name="demail", nullable=false, length=200)
    private String demail; */
     
    
    public Long getId() {
		return appid;
	}

	public void setId(Long appid) {
		this.appid = appid;
	}
	
	public String getPatientName() {
		return patientname;
	}
	
	public void setPatientName(String pname) {
		this.patientname = pname;
	}
	
	public String getDoctorName() {
		return doctorname;
	}
	
	public void setDoctorName(String dname) {
		this.doctorname = dname;
	}
	
	public String getDate() {
		return adate;
	}
	
	public void setDate(String date) {
		this.adate = date;
	}
	
	/* public String getDEmail() {
		return demail;
	}
	
	public void setDEmail(String demail) {
		this.demail = demail;
	} */
    //Setters and getters
 
   /* @Override
    public String toString() {
        return "EmployeeEntity [id=" + id + ", firstName=" + firstName + 
                ", lastName=" + lastName + ", email=" + email   + "]";
    }*/
}
