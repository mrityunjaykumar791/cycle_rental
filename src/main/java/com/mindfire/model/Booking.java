package com.mindfire.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the bookings database table.
 * 
 */
@Entity
@Table(name="bookings")
@NamedQuery(name="Booking.findAll", query="SELECT b FROM Booking b")
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="booking_id")
	private Integer bookingId;

	@Column(name="actual_in")
	private Timestamp actualIn;

	@Column(name="actual_out")
	private Timestamp actualOut;

	@Column(name="bi_cycle_id")
	private String biCycleId;

	@Column(name="booking_time")
	private Timestamp bookingTime;

	@Column(name="expected_in")
	private Timestamp expectedIn;

	@Column(name="expected_out")
	private Timestamp expectedOut;

	private double fare;

	@Column(name="is_open")
	private Boolean isOpen;

	@Column(name="picked_up_from")
	private String pickedUpFrom;

	@Column(name="returned_at")
	private String returnedAt;

	@Column(name="transaction_id")
	private String transactionId;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Booking() {
	}

	public Integer getBookingId() {
		return this.bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Timestamp getActualIn() {
		return this.actualIn;
	}

	public void setActualIn(Timestamp actualIn) {
		this.actualIn = actualIn;
	}

	public Timestamp getActualOut() {
		return this.actualOut;
	}

	public void setActualOut(Timestamp actualOut) {
		this.actualOut = actualOut;
	}

	public String getBiCycleId() {
		return this.biCycleId;
	}

	public void setBiCycleId(String biCycleId) {
		this.biCycleId = biCycleId;
	}

	public Timestamp getBookingTime() {
		return this.bookingTime;
	}

	public void setBookingTime(Timestamp bookingTime) {
		this.bookingTime = bookingTime;
	}

	public Timestamp getExpectedIn() {
		return this.expectedIn;
	}

	public void setExpectedIn(Timestamp expectedIn) {
		this.expectedIn = expectedIn;
	}

	public Timestamp getExpectedOut() {
		return this.expectedOut;
	}

	public void setExpectedOut(Timestamp expectedOut) {
		this.expectedOut = expectedOut;
	}

	public double getFare() {
		return this.fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public Boolean getIsOpen() {
		return this.isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

	public String getPickedUpFrom() {
		return this.pickedUpFrom;
	}

	public void setPickedUpFrom(String pickedUpFrom) {
		this.pickedUpFrom = pickedUpFrom;
	}

	public String getReturnedAt() {
		return this.returnedAt;
	}

	public void setReturnedAt(String returnedAt) {
		this.returnedAt = returnedAt;
	}

	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}