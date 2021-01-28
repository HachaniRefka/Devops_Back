/***************************************************************************
 * Copyright [2017] -[2019], ADDIXO All rights reserved.
 ***************************************************************************/
package com.interview.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * The Class InterviewTodoappApplication.
 */
@SpringBootApplication
@EnableJpaAuditing
public class InterviewTodoApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		SpringApplication.run(InterviewTodoApplication.class, args);
	}

}
