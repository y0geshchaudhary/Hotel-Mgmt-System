package com.HMS.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="Guest")
public class GuestDTO {
	
	
	private int stayId;
	
	@NotBlank(message="Guest name cannot be blank.")
	private String guestName;
	//private String idNumber;
	
	private int phnNo;
	private String address;
	private int noOfGuest;
	//private int noOfDays;
	@NotNull(message="Please Choose Room.")
	private RoomDTO room;
	//private String status;
	private EmployeeDTO employee;
	@NotNull(message="Please choose Check-In Date.")
	private Date checkInDate;
	@NotNull(message="Please choose Check-Out Date.")
	private Date checkOutDate;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="StayId")
	public int getStayId() {
		return stayId;
	}
	
	@Column(name="GuestName",length=20,nullable=false)
	public String getGuestName() {
		return guestName;
	}
	
	/*@Column(name="IdNumber",length=10,nullable=false)
	public String getIdNumber() {
		return idNumber;
	}*/
	
	
	@Column(name="PhnNo",length=10)
	public int getPhnNo() {
		return phnNo;
	}
	@Column(name="Address", length=50)
	public String getAddress() {
		return address;
	}
	@Column(name="NoOfGuest",length=2)
	public int getNoOfGuest() {
		return noOfGuest;
	}
	@OneToOne
	@JoinColumn(name="Room")
	public RoomDTO getRoom() {
		return room;
	}
	
	@Column(name="AarrivalDate",columnDefinition="date")
	public Date getCheckInDate() {
		return checkInDate;
	}
	
	@Column(name="DepartureDate",columnDefinition="date")
	public Date getCheckOutDate() {
		return checkOutDate;
	}

	@ManyToOne
	@JoinColumn(name="Employee",nullable=false)
	public EmployeeDTO getEmployee() {
		return employee;
	}
	
	public void setStayId(int stayId) {
		this.stayId = stayId;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	/*public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}*/
	public void setPhnNo(int phnNo) {
		this.phnNo = phnNo;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setNoOfGuest(int noOfGuest) {
		this.noOfGuest = noOfGuest;
	}
	public void setRoom(RoomDTO room) {
		this.room = room;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	

	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}

	
	
	
}
