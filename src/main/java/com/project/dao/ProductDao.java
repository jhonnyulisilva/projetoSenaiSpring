package com.project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.ProductModel;
import com.project.repository.ProductRepository;

@Service
@Transactional
public class ProductDao {

	@Autowired(required=true)
	private ProductRepository productRepository;
	
	public List<ProductModel> listAll() {
		return productRepository.findAll();
	}
		
	public ProductModel get(long idProduct) {
		return productRepository.findById(idProduct).get();
	}
	
	public void save(ProductModel productModel) {
		productRepository.save(productModel);
	}
	
	public void delete(long idProduct) {
		productRepository.deleteById(idProduct);
	}
}
