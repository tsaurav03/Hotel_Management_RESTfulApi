package com.app.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Room extends BaseEntity {
	
	@Column(name="room_number")
	@NotNull
	private String roomNumber;
	
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@Column(name="room_price",nullable = false)
	private double price;
	
	@Column(name="is_available",nullable = false)
	private boolean availability;

	public Room(@NotNull String roomNumber, Type type, double price, boolean availability) {
		super();
		this.roomNumber = roomNumber;
		this.type = type;
		this.price = price;
		this.availability = availability;
	}

	public Room() {
		super();
	}

	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", type=" + type + ", price=" + price + ", availability="
				+ availability + "]";
	}

	public Room(Long id, LocalDate creationDate, LocalDateTime updationTs) {
		super(id, creationDate, updationTs);
		// TODO Auto-generated constructor stub
	}
	
	

}
