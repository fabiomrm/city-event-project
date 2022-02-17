package com.devsuperior.bds02.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.service.EventService;

@RestController
@RequestMapping(value="/events")
public class EventResource {
	
	@Autowired
	private EventService service;
	
	
	
	@GetMapping
	public ResponseEntity<List<EventDTO>> findAll(Pageable pageable) {
		List<EventDTO> list = service.findAll(pageable);
		
		return ResponseEntity.ok().body(list);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<EventDTO> insert(@RequestBody EventDTO dto, @PathVariable Long id) {
		dto = service.update(id, dto);
		
		return ResponseEntity.ok().body(dto);
	}

}
