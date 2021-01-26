package com.interview.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.todo.model.FaceInformation;

@Repository
public interface FaceRepository extends JpaRepository<FaceInformation, Long> {

}
