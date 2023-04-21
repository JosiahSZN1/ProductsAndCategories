package com.codingdojo.productsandcategories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;

import java.util.List;



public interface CategoriesRepository extends CrudRepository<Category, Long> {
    // Retrieves a list of all categories for a particular product
    List<Category> findAllByProducts(Product product);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Category> findByProductsNotContains(Product product);

    List<Category> findAll();
}
