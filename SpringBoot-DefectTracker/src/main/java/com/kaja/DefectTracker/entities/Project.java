package com.kaja.DefectTracker.entities;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Project")
public class Project implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String projectname, projectdesc;
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private Set<Defect> defect;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getProjectdesc() {
		return projectdesc;
	}

	public void setProjectdesc(String projectdesc) {
		this.projectdesc = projectdesc;
	}

	public Set<Defect> getDefect() {
		return defect;
	}

	public void setDefect(Set<Defect> defect) {
		this.defect = defect;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
