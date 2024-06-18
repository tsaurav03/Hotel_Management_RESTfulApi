package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dtos.ApiResponse;
import com.app.dtos.ReservationDTO;
import com.app.entities.Reservation;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.ReservationRepository;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationRepository repo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ReservationDTO addReservation(ReservationDTO resrevationDTO) {
		Reservation reservationEntity=mapper.map(resrevationDTO, Reservation.class);
		repo.save(reservationEntity);
		
		return mapper.map(reservationEntity, ReservationDTO.class);
	}

	@Override
	public ApiResponse deleteReservation(Long id) {
		Reservation reservation =repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Reservation with id:"+id+"not found"));
		repo.delete(reservation);
		
		return new ApiResponse("Reservation cancelled successfully");
	}

}
