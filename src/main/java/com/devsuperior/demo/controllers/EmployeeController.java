package com.devsuperior.demo.controllers;



import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.demo.dto.EmployeeDTO;
import com.devsuperior.demo.services.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
	
	private final EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<Page<EmployeeDTO>> findAll(
			@PageableDefault(sort = "name", direction = Sort.Direction.ASC) Pageable pageable){
		return ResponseEntity.ok().body(service.findAll(pageable));
	}
	
	@PostMapping
	public ResponseEntity<EmployeeDTO> insert(@RequestBody EmployeeDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(dto.id()).toUri();
			return ResponseEntity.created(uri).body(dto);
	}	
}
