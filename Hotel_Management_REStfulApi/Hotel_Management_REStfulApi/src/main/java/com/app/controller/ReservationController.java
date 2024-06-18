package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.ReservationDTO;
import com.app.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
	
	private final ReservationService service; // Ensure it's final
	
	@Autowired
	public ReservationController(ReservationService service) {
		this.service = service;
	}
	
	@PostMapping("/")
	public ResponseEntity<?> addReservation(@RequestBody ReservationDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addReservation(dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteReservation(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(service.deleteReservation(id));
	}
	
	// Other controller methods...
}
