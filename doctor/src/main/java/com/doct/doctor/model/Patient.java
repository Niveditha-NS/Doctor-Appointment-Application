package com.doct.doctor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {

	@Id
    @GeneratedValue
    @Column(name="pid")
    private Long pid;
     
    @Column(name="pname")
    private String pname;
     
    @Column(name ="bloodgroup")
    private String bg;
    
    @Column(name ="mobnum")
    private String mobnumber;
     
    @Column(name="pemail", nullable=false, length=200)
    private String pemail;
     
    
    public Long getId() {
		return pid;
	}

	public void setId(Long pid) {
		this.pid = pid;
	}
	
	public String getPName() {
		return pname;
	}
	
	public void setPName(String pname) {
		this.pname = pname;
	}
	
	public String getPbg() {
		return bg;
	}
	
	public void setPbg(String bg) {
		this.bg = bg;
	}
	
	public String getPmobnum() {
		return mobnumber;
	}
	
	public void setPmobnum(String mobnum) {
		this.mobnumber = mobnum;
	}
	
	public String getPEmail() {
		return pemail;
	}
	
	public void setPEmail(String pemail) {
		this.pemail = pemail;
	}
    //Setters and getters
 
   /* @Override
    public String toString() {
        return "EmployeeEntity [id=" + id + ", firstName=" + firstName + 
                ", lastName=" + lastName + ", email=" + email   + "]";
    }*/
}
