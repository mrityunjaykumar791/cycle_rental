package com.mindfire.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the user_logs database table.
 * 
 */
@Entity
@Table(name="user_logs")
@NamedQuery(name="UserLog.findAll", query="SELECT u FROM UserLog u")
public class UserLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="login_time")
	private Timestamp loginTime;

	@Column(name="logout_time")
	private Timestamp logoutTime;

	@Column(name="pick_up_point_id")
	private String pickUpPointId;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public UserLog() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public Timestamp getLogoutTime() {
		return this.logoutTime;
	}

	public void setLogoutTime(Timestamp logoutTime) {
		this.logoutTime = logoutTime;
	}

	public String getPickUpPointId() {
		return this.pickUpPointId;
	}

	public void setPickUpPointId(String pickUpPointId) {
		this.pickUpPointId = pickUpPointId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}