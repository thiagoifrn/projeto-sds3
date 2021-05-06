package com.devsuperior.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.model.Seller;
import com.devsuperior.dsvendas.repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	public List<SellerDTO> buscarTodos(){
		
		List<Seller> result =  sellerRepository.findAll();
		
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
	
	public void salvar(SellerDTO dto) {
	
	}
}
