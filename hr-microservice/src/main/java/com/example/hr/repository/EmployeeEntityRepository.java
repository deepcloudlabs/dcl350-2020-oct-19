package com.example.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hr.entity.EmployeeEntity;

//Spring Data Jpa
public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, String>{

}
