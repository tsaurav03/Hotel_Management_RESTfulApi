package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dtos.RoomDTO;
import com.app.repository.RoomRepository;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomRepository repo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<RoomDTO> getAllRooms() {
		List<RoomDTO> populatedListOfDTO = repo.findAll().stream().filter(i -> i.isAvailability())
				.map(entity -> mapper.map(entity, RoomDTO.class)).collect(Collectors.toList());
		return populatedListOfDTO;

	}

}
