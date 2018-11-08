package com.antawa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	/**
	 * Description of the property CI.
	 */
	@Column(unique = true, nullable = false,length = 10)
	private String cedula;
		
	/**
	 * Description of the property first name.
	 */
	@Column(nullable = false,length = 70)
	private String firstName;

    /**
	 * Description of the property last name.
	 */
	@Column(nullable = false,length = 70)
    private String lastName;
	
	/**
	 * Description of the property address.
	 */
	@Column(nullable = false,length = 70)
    private String address;
	
	/**
	 * Description of the property phone.
	 */
	@Column(nullable = false,length = 70)
    private String phone;
	
	/**
	 * Description of the property email.
	 */
	@Column(nullable = false,length = 150)
    private String email;


	/**
	 * Description of the property gender.
	 */
	@Column(length = 70)
    private Integer gender;
	
	/**
	 * Description of the property Nationality.
	 */
	@Column(length = 70)
    private Integer nationality;
	
    public Person(){
    	
    }
    
    public Person(String cedula,String firstName,String lastName,String address, String phone,String email,
    		Integer gender, Integer nationality){
    	this.cedula 	= cedula;
    	this.firstName	= firstName;
    	this.lastName	= lastName;
    	this.address	= address;
    	this.phone		= phone;
    	this.email		= email;
    	this.gender		= gender;
    	this.nationality		= nationality;
    }

    public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getNationality() {
		return nationality;
	}

	public void setNationality(Integer nationality) {
		this.nationality = nationality;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	} 
}
