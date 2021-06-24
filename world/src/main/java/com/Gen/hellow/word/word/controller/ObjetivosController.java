package com.Gen.hellow.word.word.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/objetivos")
public class ObjetivosController {
	
	@GetMapping
	public String objetivos() {
		
		return "- Aprender O Spring Boot"
		+ " - Aprender mais sobre API"
		+ " - Aprender mais sobre as requisições"
		+ " - Aprender mais sobre a manipulação do Spring"
		+ " - Aprender como fazer o MVC";
		
	};
}
