/***************************************************************************
 * Copyright [2017] -[2019], ADDIXO All rights reserved.
 ***************************************************************************/
package com.interview.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.todo.model.Todo;

/**
 * The Interface TodoRepository.
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
