package com.HMS.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Room")
public class RoomDTO {

	private int roomId;
	private int roomFloor;
	private int roomRate;
	private int numberOfBeds;
	private int roomOutOfOrder;
	private GuestDTO guest;
	
	
	@Id
	@Column(name="RoomId",nullable=false,length=2)
	public int getRoomId() {
		return roomId;
	}
	@Column(name="Floor",nullable=false,length=2)
	public int getRoomFloor() {
		return roomFloor;
	}
	@Column(name="Rates",nullable=false,length=3)
	public int getRoomRate() {
		return roomRate;
	}
	@Column(name="NoOfBeds",nullable=false,length=1)
	public int getNumberOfBeds() {
		return numberOfBeds;
	}
	@Column(name="OutOfOrder",nullable=false,length=1)
	public int getRoomOutOfOrder() {
		return roomOutOfOrder;
	}
	@OneToOne(mappedBy="room")
	public GuestDTO getGuest() {
		return guest;
	}
	public void setGuest(GuestDTO guest) {
		this.guest = guest;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public void setRoomFloor(int roomFloor) {
		this.roomFloor = roomFloor;
	}
	public void setRoomRate(int roomRate) {
		this.roomRate = roomRate;
	}
	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}
	public void setRoomOutOfOrder(int roomOutOfOrder) {
		this.roomOutOfOrder = roomOutOfOrder;
	}
	
	
	
	
}
