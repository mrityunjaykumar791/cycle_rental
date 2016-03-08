package com.mindfire.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the booking_transaction database table.
 * 
 */
@Entity
@Table(name="booking_transaction")
@NamedQuery(name="BookingTransaction.findAll", query="SELECT b FROM BookingTransaction b")
public class BookingTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="booking_id")
	private String bookingId;

	@Column(name="transaction_id")
	private String transactionId;

	public BookingTransaction() {
	}

	public String getBookingId() {
		return this.bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}