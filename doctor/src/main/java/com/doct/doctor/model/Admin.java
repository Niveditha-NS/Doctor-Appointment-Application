package com.doct.doctor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admins")
public class Admin {

	@Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
     
    @Column(name="name")
    private String name;
     
     
    @Column(name="email", nullable=false, length=200)
    private String email;
     
   /* public EmployeeEntity(Long i,String fn,String ln, String e)
    {
    	this.id=i;
    	this.firstName=fn;
    	this.lastName=ln;
    	this.email=e;
    } */
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
    //Setters and getters
 
   /* @Override
    public String toString() {
        return "EmployeeEntity [id=" + id + ", firstName=" + firstName + 
                ", lastName=" + lastName + ", email=" + email   + "]";
    }*/

}
