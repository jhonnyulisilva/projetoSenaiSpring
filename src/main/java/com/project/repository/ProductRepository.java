package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
	
	

}
