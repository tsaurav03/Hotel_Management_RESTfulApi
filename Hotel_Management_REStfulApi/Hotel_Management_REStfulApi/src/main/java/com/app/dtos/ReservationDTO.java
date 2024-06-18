package com.app.dtos;

import java.time.LocalDate;

import com.app.entities.Room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {

	private String name;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private Room room;

	private double price;
}
