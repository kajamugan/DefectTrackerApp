package com.kaja.DefectTracker.entities;

import java.io.Serializable;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;



@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private List<Modules> module;
	private String name, nic, dateofbrith, address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getDateofbrith() {
		return dateofbrith;
	}

	public void setDateofbrith(String dateofbrith) {
		this.dateofbrith = dateofbrith;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Modules> getModule() {
		return module;
	}

	public void setModule(List<Modules> module) {
		this.module = module;
	}

}
