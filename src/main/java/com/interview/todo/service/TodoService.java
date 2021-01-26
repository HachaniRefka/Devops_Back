/***************************************************************************
 * Copyright [2017] -[2019], ADDIXO All rights reserved.
 ***************************************************************************/
package com.interview.todo.service;

import java.util.List;
import java.util.Optional;

import com.interview.todo.model.Todo;

/**
 * The Interface TodoService.
 */
public interface TodoService {

	/**
	 * Adds the todo.
	 *
	 * @param todo the todo
	 * @return the optional
	 */
	Todo addTodo(Todo todo);


	/**
	 * Update todo.
	 *
	 * @param todo the todo
	 * @return the optional
	 */
	Todo updateTodo(Todo todo);


	/**
	 * Delete todo.
	 *
	 * @param todoId the todo id
	 */
	void deleteTodo(Long todoId);

	/**
	 * Gets the all todos.
	 *
	 * @return the all todos
	 */
	List<Todo> getAllTodos();

	/**
	 * Gets the todo by id.
	 *
	 * @param todoId the todo id
	 * @return the todo by id
	 */
	Optional<Todo> getTodoById(Long todoId);

}
