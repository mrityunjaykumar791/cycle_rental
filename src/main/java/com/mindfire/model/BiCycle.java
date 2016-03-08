package com.mindfire.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the bi_cycles database table.
 * 
 */
@Entity
@Table(name="bi_cycles")
@NamedQuery(name="BiCycle.findAll", query="SELECT b FROM BiCycle b")
public class BiCycle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bi_cycle_id")
	private Integer biCycleId;

	@Column(name="added_on")
	private Timestamp addedOn;

	@Column(name="chasis_no")
	private String chasisNo;

	@Column(name="current_location")
	private String currentLocation;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_available")
	private Boolean isAvailable;

	public BiCycle() {
	}

	public Integer getBiCycleId() {
		return this.biCycleId;
	}

	public void setBiCycleId(Integer biCycleId) {
		this.biCycleId = biCycleId;
	}

	public Timestamp getAddedOn() {
		return this.addedOn;
	}

	public void setAddedOn(Timestamp addedOn) {
		this.addedOn = addedOn;
	}

	public String getChasisNo() {
		return this.chasisNo;
	}

	public void setChasisNo(String chasisNo) {
		this.chasisNo = chasisNo;
	}

	public String getCurrentLocation() {
		return this.currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsAvailable() {
		return this.isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

}