package com.devsuperior.dsvendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsvendas.model.Sale;

public interface SaleRepository extends JpaRepository<Sale,Long> {

}
