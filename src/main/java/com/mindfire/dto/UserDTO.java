package com.mindfire.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class UserDTO {
	private String firstName;
	private String lastName;
	private Long mobileNo;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private Date dateOfBirth;
	private String email;
	private String userAddress;
	private String proofType;
	private String proofNo;
	private String document;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the mobileNo
	 */
	public Long getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo
	 *            the mobileNo to set
	 */
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the userAddress
	 */
	public String getUserAddress() {
		return userAddress;
	}

	/**
	 * @param userAddress
	 *            the userAddress to set
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	/**
	 * @return the proofType
	 */
	public String getProofType() {
		return proofType;
	}

	/**
	 * @param proofType
	 *            the proofType to set
	 */
	public void setProofType(String proofType) {
		this.proofType = proofType;
	}

	/**
	 * @return the proofNo
	 */
	public String getProofNo() {
		return proofNo;
	}

	/**
	 * @param proofNo
	 *            the proofNo to set
	 */
	public void setProofNo(String proofNo) {
		this.proofNo = proofNo;
	}

	/**
	 * @return the document
	 */
	public String getDocument() {
		return document;
	}

	/**
	 * @param document
	 *            the document to set
	 */
	public void setDocument(String document) {
		this.document = document;
	}

}
