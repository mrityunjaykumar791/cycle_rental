package com.mindfire.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the transfers database table.
 * 
 */
@Entity
@Table(name="transfers")
@NamedQuery(name="Transfer.findAll", query="SELECT t FROM Transfer t")
public class Transfer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transfer_id")
	private Integer transferId;

	@Column(name="arrived_on")
	private Timestamp arrivedOn;

	@Column(name="dispatched_at")
	private Timestamp dispatchedAt;

	private Integer quantity;

	@Column(name="transferred_from")
	private String transferredFrom;

	@Column(name="transferred_to")
	private String transferredTo;

	@Column(name="vehicle_no")
	private String vehicleNo;

	public Transfer() {
	}

	public Integer getTransferId() {
		return this.transferId;
	}

	public void setTransferId(Integer transferId) {
		this.transferId = transferId;
	}

	public Timestamp getArrivedOn() {
		return this.arrivedOn;
	}

	public void setArrivedOn(Timestamp arrivedOn) {
		this.arrivedOn = arrivedOn;
	}

	public Timestamp getDispatchedAt() {
		return this.dispatchedAt;
	}

	public void setDispatchedAt(Timestamp dispatchedAt) {
		this.dispatchedAt = dispatchedAt;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getTransferredFrom() {
		return this.transferredFrom;
	}

	public void setTransferredFrom(String transferredFrom) {
		this.transferredFrom = transferredFrom;
	}

	public String getTransferredTo() {
		return this.transferredTo;
	}

	public void setTransferredTo(String transferredTo) {
		this.transferredTo = transferredTo;
	}

	public String getVehicleNo() {
		return this.vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

}