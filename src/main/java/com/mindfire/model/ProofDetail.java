package com.mindfire.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proof_details database table.
 * 
 */
@Entity
@Table(name="proof_details")
@NamedQuery(name="ProofDetail.findAll", query="SELECT p FROM ProofDetail p")
public class ProofDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="proof_id")
	private Long proofId;

	private String document;

	@Column(name="proof_no")
	private String proofNo;

	@Column(name="proof_type")
	private String proofType;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="proofDetail")
	private List<User> users;

	public ProofDetail() {
	}

	public Long getProofId() {
		return this.proofId;
	}

	public void setProofId(Long proofId) {
		this.proofId = proofId;
	}

	public String getDocument() {
		return this.document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getProofNo() {
		return this.proofNo;
	}

	public void setProofNo(String proofNo) {
		this.proofNo = proofNo;
	}

	public String getProofType() {
		return this.proofType;
	}

	public void setProofType(String proofType) {
		this.proofType = proofType;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setProofDetail(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setProofDetail(null);

		return user;
	}

}