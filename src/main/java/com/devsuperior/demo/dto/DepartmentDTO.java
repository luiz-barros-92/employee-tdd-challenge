package com.devsuperior.demo.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.devsuperior.demo.entities.Department;

public record DepartmentDTO(
	Long id,
	String name,
	List<EmployeeDTO> employees) {
	
	public DepartmentDTO(Department entity) {
		this(
			entity.getId(),
			entity.getName(),
			entity.getEmployees()
				.stream()
				.map(EmployeeDTO::new)
				.collect(Collectors.toList())
		);
	}
}
