package com.codingdojo.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.repositories.ProductsRepository;

@Service
public class ProductService {
	@Autowired
	private ProductsRepository productsRepository;
	
	public Product findProductByID(Long id) {
		Optional<Product> foundProduct = productsRepository.findById(id);
		if(foundProduct.isPresent()) {
			return foundProduct.get();
		} else {
			return null;
		}
	}
	
	public List<Product> getAllProducts() {
		return productsRepository.findAll();
	}
	
	public Product createOrUpdateProduct(Product p) {
		return productsRepository.save(p);
	}
	
	public List<Product> getAllAssignedProductsOfCategory(Category category) {
		return productsRepository.findAllByCategories(category);
	}
	
	public List<Product> getAllUnassignedProductsOfCategory(Category category) {
		return productsRepository.findByCategoriesNotContains(category);
	}
}
