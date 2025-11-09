package com.devsuperior.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.demo.dto.DepartmentSimpleDTO;
import com.devsuperior.demo.services.DepartmentService;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

	private final DepartmentService service;

	public DepartmentController(DepartmentService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<DepartmentSimpleDTO>> findAll() {
		List<DepartmentSimpleDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
