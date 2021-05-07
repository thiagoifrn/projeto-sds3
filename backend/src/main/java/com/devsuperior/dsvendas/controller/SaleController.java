package com.devsuperior.dsvendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.service.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService saleService;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> buscarTodos(Pageable pageable){
		
		Page<SaleDTO> list = saleService.buscarTodos(pageable);
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/all-sale-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupBySeller(){
		
		List<SaleSumDTO> list = saleService.amountGroupBySeller();
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupBySeller(){
		
		List<SaleSuccessDTO> list = saleService.successGroupBySeller();
		
		return ResponseEntity.ok(list);
	}
	
	
}
