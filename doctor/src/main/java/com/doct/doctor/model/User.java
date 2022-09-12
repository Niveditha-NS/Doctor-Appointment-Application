package com.doct.doctor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbusers")
public class User {

	@Id
    @GeneratedValue
    @Column(name="userid")
    private Long usersid;
     
    @Column(name="username")
    private String usersname;
     
    @Column(name ="password")
    private String pswd;
    
    @Column(name ="role")
    private String roles;
     
   /* @Column(name="demail", nullable=false, length=200)
    private String demail; */
     
    
    public Long getId() {
		return usersid;
	}

	public void setId(Long userid) {
		this.usersid = userid;
	}
	
	public String getUName() {
		return usersname;
	}
	
	public void setUName(String uname) {
		this.usersname = uname;
	}
	
	public String getPassword() {
		return pswd;
	}
	
	public void setPassword(String password) {
		this.pswd = password;
	}
	
	public String getRole() {
		return roles;
	}
	
	public void setRole(String role) {
		this.roles = role;
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
