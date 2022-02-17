package com.devsuperior.bds02.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.service.exceptions.DatabaseException;
import com.devsuperior.bds02.service.exceptions.ResourceNotFoundException;

@Service
public class CityService {

	@Autowired
	private CityRepository repository;
	
	@Transactional(readOnly = true)
	public List<CityDTO> findAll(Pageable pagable) {
		List<City> list = repository.findAll(Sort.by("name"));
		
		return list.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public CityDTO insert(CityDTO dto) {
		City entity = new City();
		entity = convertDtoToEntity(dto, entity);
		
		entity = repository.save(entity);
		
		return new CityDTO(entity);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException  e) {
			throw new ResourceNotFoundException("Id not found: " + id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException("City has event attached");
		}
	}
	
	private City convertDtoToEntity(CityDTO dto, City entity) {
		entity.setName(dto.getName());
		
		return entity;
	}
}
