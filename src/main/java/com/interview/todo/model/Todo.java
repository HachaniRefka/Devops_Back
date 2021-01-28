/***************************************************************************
 * Copyright [2017] -[2019], ADDIXO All rights reserved.
 ***************************************************************************/

package com.interview.todo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

/**
 * The Class Todo.
 */
@Data
@Entity
@Table(name = "todo")
public class Todo implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name = "id")
	private Long id;

	/** The title. **/
	@Column(name = "title")
	private String title;

	/** The completed. */
	@Column(name = "status")
	private Boolean completed = false;

	@PrePersist
	private void setIdAuto() {
		this.id = new Date().getTime();
	}

}
