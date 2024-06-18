package com.app.service;

import com.app.dtos.ApiResponse;
import com.app.dtos.ReservationDTO;

public interface ReservationService {
  ReservationDTO addReservation(ReservationDTO resrevationDTO);
  ApiResponse deleteReservation(Long id);
}
