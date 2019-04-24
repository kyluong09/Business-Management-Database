package com.spring.boot.thymeleaf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="address")
	private String address;
	@Column(name="ward")
	private String ward;
	@Column(name="district")
	private String district;
	
	
	public Address(){
		
	}


	public Address(String address, String ward, String district) {
		this.address = address;
		this.ward = ward;
		this.district = district;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getWard() {
		return ward;
	}


	public void setWard(String ward) {
		this.ward = ward;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}
	
	
	

	@Override
	public String toString() {
		return address + " " + ", Ward " +ward + ", District " + district;
	}
	
	
	
	

}
