package com.devsuperior.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.demo.dto.DepartmentSimpleDTO;
import com.devsuperior.demo.entities.Department;
import com.devsuperior.demo.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	private final DepartmentRepository repository;

	public DepartmentService(DepartmentRepository repository) {
		this.repository = repository;
	}
	
	@Transactional(readOnly = true)
	public List<DepartmentSimpleDTO> findAll(){
		List<Department> list = repository.findAll(Sort.by("name"));
		return list.stream()
				.map(DepartmentSimpleDTO::new)
				.collect(Collectors.toList());
	}
}
