package com.mindfire.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bi_cycle_transfer database table.
 * 
 */
@Entity
@Table(name="bi_cycle_transfer")
@NamedQuery(name="BiCycleTransfer.findAll", query="SELECT b FROM BiCycleTransfer b")
public class BiCycleTransfer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bi_cycle_id")
	private String biCycleId;

	@Column(name="transfer_id")
	private String transferId;

	public BiCycleTransfer() {
	}

	public String getBiCycleId() {
		return this.biCycleId;
	}

	public void setBiCycleId(String biCycleId) {
		this.biCycleId = biCycleId;
	}

	public String getTransferId() {
		return this.transferId;
	}

	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}

}