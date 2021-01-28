/***************************************************************************
 * Copyright [2017] -[2019], ADDIXO All rights reserved.
 ***************************************************************************/
package com.interview.todo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.interview.todo.model.Todo;

/**
 * The Interface TodoRepository.
 */
@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

}
