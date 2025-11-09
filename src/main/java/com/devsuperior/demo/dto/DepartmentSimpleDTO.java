package com.devsuperior.demo.dto;

import com.devsuperior.demo.entities.Department;

public record DepartmentSimpleDTO(
	Long id,
	String name) {

	public DepartmentSimpleDTO(Department entity) {
		this(
			entity.getId(),
			entity.getName()
		);
	}
}
