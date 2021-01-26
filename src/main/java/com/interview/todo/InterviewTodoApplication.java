/***************************************************************************
 * Copyright [2017] -[2019], ADDIXO All rights reserved.
 ***************************************************************************/
package com.interview.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.interview.todo.service.MqttService;

/**
 * The Class InterviewTodoappApplication.
 */
@SpringBootApplication
@EnableJpaAuditing
public class InterviewTodoApplication implements CommandLineRunner {

	@Autowired
	private MqttService messagingService;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		SpringApplication.run(InterviewTodoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		final String topic = "/python/mqtt";

		messagingService.subscribe(topic);

	}

}
