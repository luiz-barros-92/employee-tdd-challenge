package com.devsuperior.demo.dto;

import com.devsuperior.demo.entities.Employee;

public record EmployeeDTO(
	Long id,
	String name,
	String email,
	Long departmentId) {
	
	public EmployeeDTO(Employee entity) {
		this(
			entity.getId(),
			entity.getName(),
			entity.getEmail(),
			entity.getDepartment().getId());		
	}
}
