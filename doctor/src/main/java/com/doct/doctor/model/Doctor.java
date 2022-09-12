package com.doct.doctor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {

	@Id
    @GeneratedValue
    @Column(name="did")
    private Long did;
     
    @Column(name="dname")
    private String dname;
     
    @Column(name ="hospitalname")
    private String hosname;
    
    @Column(name ="dmobnum")
    private String dmobnumber;
     
    @Column(name="demail", nullable=false, length=200)
    private String demail;
     
    
    public Long getId() {
		return did;
	}

	public void setId(Long did) {
		this.did = did;
	}
	
	public String getDName() {
		return dname;
	}
	
	public void setDName(String dname) {
		this.dname = dname;
	}
	
	public String getHName() {
		return hosname;
	}
	
	public void setHName(String hosname) {
		this.hosname = hosname;
	}
	
	public String getDmobnum() {
		return dmobnumber;
	}
	
	public void setDmobnum(String dmobnum) {
		this.dmobnumber = dmobnum;
	}
	
	public String getDEmail() {
		return demail;
	}
	
	public void setDEmail(String demail) {
		this.demail = demail;
	}
    //Setters and getters
 
   /* @Override
    public String toString() {
        return "EmployeeEntity [id=" + id + ", firstName=" + firstName + 
                ", lastName=" + lastName + ", email=" + email   + "]";
    }*/
}

