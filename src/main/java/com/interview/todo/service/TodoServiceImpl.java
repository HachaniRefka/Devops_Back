/***************************************************************************
 * Copyright [2017] -[2019], ADDIXO All rights reserved.
 ***************************************************************************/
package com.interview.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interview.todo.model.Todo;
import com.interview.todo.repository.TodoRepository;

/**
 * The Class TodoServiceImpl.
 */
@Service
@Transactional
public class TodoServiceImpl implements TodoService {

	/** The todo repo. */
	@Autowired
	TodoRepository todoRepo;

	/**
	 * Adds the todo.
	 *
	 * @param todo the todo
	 * @return the optional
	 */
	@Override
	public Todo addTodo(final Todo todo) {

		return this.todoRepo.save(todo);
	}


	/**
	 * Update todo.
	 *
	 * @param todo the todo
	 * @return the optional
	 */
	@Override
	public Todo updateTodo(final Todo todo) {

		return this.addTodo(todo);
	}

	/**
	 * Gets the all todos.
	 *
	 * @return the all todos
	 */
	@Override
	public List<Todo> getAllTodos() {

		Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
		return this.todoRepo.findAll(sortByCreatedAtDesc);
	}

	/**
	 * Gets the todo by id.
	 *
	 * @param todoId the todo id
	 * @return the todo by id
	 */
	@Override
	public Optional<Todo> getTodoById(final Long todoId) {

		return this.todoRepo.findById(todoId);
	}


	/**
	 * Delete todo.
	 *
	 * @param todoId the todo id
	 */
	@Override
	public void deleteTodo(final Long todoId) {

		this.getTodoById(todoId).ifPresent(todoObject -> this.todoRepo.delete(todoObject));
	}


}
