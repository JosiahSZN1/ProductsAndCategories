package com.codingdojo.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.repositories.CategoriesRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoriesRepository categoriesRepository;
	@Autowired
	private ProductService productService;
	
	public Category findCategoryByID(Long id) {
		Optional<Category> foundCategory = categoriesRepository.findById(id);
		if(foundCategory.isPresent()) {
			return foundCategory.get();
		} else {
			return null;
		}
	}
	
	public Category categorizeProduct(Long categoryID, Long productID) {
		Category thisCategory = this.findCategoryByID(categoryID);
		Product thisProduct = productService.findProductByID(productID);
		thisCategory.getProducts().add(thisProduct);
		return categoriesRepository.save(thisCategory);
	}
	
	public List<Category> getAllCategories() {
		return categoriesRepository.findAll();
	}
	
	public Category createOrUpdateCategory(Category c) {
		return categoriesRepository.save(c);
	}
	
	public List<Category> getAllAssignedCategoriesOfProduct(Product product) {
		return categoriesRepository.findAllByProducts(product);
	}
	
	public List<Category> getAllUnassignedCategoriesOfProduct(Product product) {
		return categoriesRepository.findByProductsNotContains(product);
	}
}
