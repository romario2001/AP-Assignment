package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "consult")
public class consult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "nic")
	private String nic;
	
	@Column(name = "available_dates")
	private String available_dates;

	@Column(name = "time_slot")
	private String time_slot;
	
	@Column(name = "password")
	private String password;

	
	
	public consult(long id, String name, String email, String nic, String available_dates, String time_slot,
			String password) {
		super();
		Id = id;
		this.name = name;
		this.email = email;
		this.nic = nic;
		this.available_dates = available_dates;
		this.time_slot = time_slot;
		this.password = password;
	}

	public consult() {
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
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

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getAvailable_dates() {
		return available_dates;
	}

	public void setAvailable_dates(String available_dates) {
		this.available_dates = available_dates;
	}

	public String getTime_slot() {
		return time_slot;
	}

	public void setTime_slot(String time_slot) {
		this.time_slot = time_slot;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
}
