package org.sample.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.sample.util.JsonDateSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class Ticket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticketId;

	private String passengerName;

	@JsonSerialize(using = JsonDateSerializer.class)
	private Date bookingDate;

	private String sourceStation;

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}

	@Override
	public String toString() {
		return String.format("Ticket [ticketId=%s, passengerName=%s, bookingDate=%s, sourceStation=%s]", ticketId,
				passengerName, bookingDate, sourceStation);
	}

	public Ticket() {
	}

	public Ticket(String passengerName, Date bookingDate, String sourceStation) {
		this.passengerName = passengerName;
		this.bookingDate = bookingDate;
		this.sourceStation = sourceStation;
	}

}
