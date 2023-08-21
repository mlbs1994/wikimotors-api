package com.wikimotors.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("automoveis")
public class AutomovelController {
	
	@GetMapping
	public ResponseEntity<String> detail(){
		return ResponseEntity.ok("Olá mundo");
	}
	
	
}
