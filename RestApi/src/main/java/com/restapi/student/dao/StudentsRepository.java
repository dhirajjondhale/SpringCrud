package com.restapi.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.student.entities.Students;

public interface StudentsRepository extends JpaRepository<Students, Integer> {

}
