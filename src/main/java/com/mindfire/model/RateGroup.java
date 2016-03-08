package com.mindfire.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the rate_groups database table.
 * 
 */
@Entity
@Table(name="rate_groups")
@NamedQuery(name="RateGroup.findAll", query="SELECT r FROM RateGroup r")
public class RateGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rate_group_id")
	private Integer rateGroupId;

	@Column(name="base_rate")
	private double baseRate;

	private double discount;

	@Temporal(TemporalType.DATE)
	@Column(name="effective_from")
	private Date effectiveFrom;

	@Temporal(TemporalType.DATE)
	@Column(name="effective_upto")
	private Date effectiveUpto;

	@Column(name="group_type")
	private String groupType;

	public RateGroup() {
	}

	public Integer getRateGroupId() {
		return this.rateGroupId;
	}

	public void setRateGroupId(Integer rateGroupId) {
		this.rateGroupId = rateGroupId;
	}

	public double getBaseRate() {
		return this.baseRate;
	}

	public void setBaseRate(double baseRate) {
		this.baseRate = baseRate;
	}

	public double getDiscount() {
		return this.discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Date getEffectiveFrom() {
		return this.effectiveFrom;
	}

	public void setEffectiveFrom(Date effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}

	public Date getEffectiveUpto() {
		return this.effectiveUpto;
	}

	public void setEffectiveUpto(Date effectiveUpto) {
		this.effectiveUpto = effectiveUpto;
	}

	public String getGroupType() {
		return this.groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

}