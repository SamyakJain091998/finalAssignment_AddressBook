package com.blz.addressBook.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Table(name = "addresses")
public @Data class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "---------------------Contact name invalid...!!!--------------------------")
	@Column(name = "name")
	private String name;

	@Pattern(regexp = "^[1-9]{1}[0-9]{9}$", message = "---------------------Contact phoneNumber invalid...!!!--------------------------")
	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Pattern(regexp = "^[0-9]{6}$", message = "---------------------Contact zip invalid...!!!--------------------------")
	@Column(name = "zip_code")
	private String zip;

	public Address() {

	}

	public Address(String name, String phoneNumber, String address, String city, String state, String zip) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public Address(String string, List<String> errMsg) {

	}

}
