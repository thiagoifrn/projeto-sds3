package com.devsuperior.dsvendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.service.SellerService;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {
	@Autowired
	private SellerService sellerService;
	
	@GetMapping
	public ResponseEntity<List<SellerDTO>> buscarTodos(){
		
		List<SellerDTO> list = sellerService.buscarTodos();
		
		return ResponseEntity.ok(list);
	}
}
