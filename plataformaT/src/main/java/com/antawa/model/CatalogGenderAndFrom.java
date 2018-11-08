package com.antawa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "catalogGF")
public class CatalogGenderAndFrom implements Serializable {
	
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
	 * Description of the property id father.
	 */
	@Column
	private Long id_father;
		
	/**
	 * Description of the property name.
	 */
	@Column(nullable = false,length = 70)
	private String name;
	
	public CatalogGenderAndFrom(){
    	
    }
    
    public CatalogGenderAndFrom(Long id_father,String name){
    	this.id_father 	= id_father;
    	this.name	= name;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_father() {
		return id_father;
	}

	public void setId_father(Long id_father) {
		this.id_father = id_father;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
