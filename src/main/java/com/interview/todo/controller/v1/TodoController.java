/***************************************************************************
 * Copyright [2017] -[2019], ADDIXO All rights reserved.
 ***************************************************************************/
package com.interview.todo.controller.v1;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.todo.constants.CommonConstants;
import com.interview.todo.model.Todo;
import com.interview.todo.service.TodoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description of the class.
 *
 * @author ahmed.hamed
 * @since
 */
@RestController
@RequestMapping("/todoapi/v1")
@CrossOrigin("*")
@Api(value = "todo-endpoint")
public class TodoController {

	/** The todo service. */
	@Autowired
	TodoService todoService;

	/**
	 * Gets the all todos.
	 *
	 * @return the all todos
	 */
	@ApiOperation(value = "View the list of available todos", response = List.class)
	@GetMapping("/todos")
	public List<Todo> getAllTodos() {

		return this.todoService.getAllTodos();
	}

	/**
	 * Creates the todo.
	 *
	 * @param todo the todo
	 * @return the optional
	 */
	@ApiOperation("Creates a new todo")
	@PostMapping("/todos")
	public ResponseEntity<Todo> createTodo(@RequestBody final Todo todo) {

		todo.setCompleted(false);
		return ResponseEntity.ok().body(this.todoService.addTodo(todo));
	}

	/**
	 * Gets the todo by id.
	 *
	 * @param id the id
	 * @return the todo by id
	 */
	@ApiOperation("View a todo by its ID")
	@GetMapping("/todos/{id}")
	public ResponseEntity<Todo> getTodoById(@PathVariable("id") final Long id) {

		Todo fetchedTodo = this.todoService.getTodoById(id)
				.orElseThrow(() -> new ResourceNotFoundException(CommonConstants.TODO_ID_NOT_FOUND + id));
		return ResponseEntity.ok().body(fetchedTodo);
	}

	/**
	 * Update todo.
	 *
	 * @param id the id
	 * @param newTodo the new todo
	 * @return the response entity
	 */
	@ApiOperation("Updates a todo")
	@PutMapping("/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable("id") final Long id,
			@Valid @RequestBody final Todo newTodo) {

		Todo oldTodo = this.todoService.getTodoById(id)
				.orElseThrow(() -> new ResourceNotFoundException(CommonConstants.TODO_ID_NOT_FOUND + id));
		newTodo.setId(oldTodo.getId());
		return ResponseEntity.ok().body(this.todoService.updateTodo(newTodo));
	}

	/**
	 * Delete todo.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@ApiOperation("Removes a todo")
	@DeleteMapping("/todos/{id}")
	public void deleteTodo(@PathVariable("id") final Long id) {

		this.todoService.getTodoById(id)
				.orElseThrow(() -> new ResourceNotFoundException(CommonConstants.TODO_ID_NOT_FOUND + id));
		this.todoService.deleteTodo(id);
	}
	
	@PatchMapping("/todos/id")
	public void patch (@PathVariable("id") final Long id) {
		System.out.println("Bonjour");
	}


}
