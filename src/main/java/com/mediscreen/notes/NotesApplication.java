package com.mediscreen.notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotesApplication {

	/**
	 * Cette fonction est le point d'entrée du micro-service Notes
	 * @param args
	 */

	public static void main(String[] args) {
		SpringApplication.run(NotesApplication.class, args);
	}

}
