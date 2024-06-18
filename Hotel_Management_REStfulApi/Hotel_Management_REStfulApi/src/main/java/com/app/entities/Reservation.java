package com.app.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Reservation extends BaseEntity {
	
	@NotBlank
	@Column(name = "reservation_name")
	private String name;
	
	@NotNull
	@Column(name = "check_in_dt")
	private LocalDate checkInDate;
	
	@NotNull
	@Column(name="check_out_dt")
	private LocalDate checkOutDate;
	
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Room room;
	
	@Min(70)
	private double price;

	

	public Reservation() {
		super();
	}

	public Reservation(Long id, LocalDate creationDate, LocalDateTime updationTs) {
		super(id, creationDate, updationTs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Reservation [name=" + name + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate
				+ ", room=" + room + ", price=" + price + "]";
	}

	public Reservation(@NotBlank String name, @NotNull LocalDate checkInDate, @NotNull LocalDate checkOutDate,
			Room room, @NotBlank double price) {
		super();
		this.name = name;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.room = room;
		this.price = price;
	}
	
	

}
