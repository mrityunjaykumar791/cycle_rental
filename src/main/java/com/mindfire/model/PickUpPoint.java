package com.mindfire.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the pick_up_points database table.
 * 
 */
@Entity
@Table(name="pick_up_points")
@NamedQuery(name="PickUpPoint.findAll", query="SELECT p FROM PickUpPoint p")
public class PickUpPoint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pick_up_point_id")
	private Integer pickUpPointId;

	@Column(name="added_on")
	private Timestamp addedOn;

	@Column(name="current_availability")
	private Integer currentAvailability;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_open")
	private Boolean isOpen;

	private String location;

	@Column(name="max_capacity")
	private Integer maxCapacity;

	public PickUpPoint() {
	}

	public Integer getPickUpPointId() {
		return this.pickUpPointId;
	}

	public void setPickUpPointId(Integer pickUpPointId) {
		this.pickUpPointId = pickUpPointId;
	}

	public Timestamp getAddedOn() {
		return this.addedOn;
	}

	public void setAddedOn(Timestamp addedOn) {
		this.addedOn = addedOn;
	}

	public Integer getCurrentAvailability() {
		return this.currentAvailability;
	}

	public void setCurrentAvailability(Integer currentAvailability) {
		this.currentAvailability = currentAvailability;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsOpen() {
		return this.isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getMaxCapacity() {
		return this.maxCapacity;
	}

	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

}