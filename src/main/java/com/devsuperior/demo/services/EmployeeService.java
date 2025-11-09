package com.devsuperior.demo.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.demo.dto.EmployeeDTO;
import com.devsuperior.demo.entities.Department;
import com.devsuperior.demo.entities.Employee;
import com.devsuperior.demo.repositories.DepartmentRepository;
import com.devsuperior.demo.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	private final EmployeeRepository repository;
	private final DepartmentRepository departmentRepository;

	public EmployeeService(EmployeeRepository repository, DepartmentRepository departmentRepository) {
		this.repository = repository;
		this.departmentRepository = departmentRepository;
	}
	
	@Transactional(readOnly = true)
	public Page<EmployeeDTO> findAll(Pageable pageable){
		Page<Employee> page = repository.findAll(pageable);
		return page.map(EmployeeDTO::new);
	}
	
	@Transactional
	public EmployeeDTO insert(EmployeeDTO dto) {
		Employee entity = new Employee();
		entity.setName(dto.name());
		entity.setEmail(dto.email());
		Department department = departmentRepository.getReferenceById(dto.departmentId());
		entity.setDepartment(department);
		entity = repository.save(entity);
		return new EmployeeDTO(entity);		
	}
}
