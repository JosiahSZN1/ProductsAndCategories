package com.codingdojo.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.services.CategoryService;
import com.codingdojo.productsandcategories.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductsController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/new")
	public String rNewProduct(@ModelAttribute("newProduct") Product product) {
		return "newProduct.jsp";
	}
	
	@GetMapping("/{productID}")
	public String rShowProduct(
		Model model,
		@PathVariable("productID") Long productID) {
		Product thisProduct = productService.findProductByID(productID);
		model.addAttribute("thisProduct", thisProduct);
		model.addAttribute("assignedCategories", categoryService.getAllAssignedCategoriesOfProduct(thisProduct));
		model.addAttribute("unassignedCategories", categoryService.getAllUnassignedCategoriesOfProduct(thisProduct));
		return "showProduct.jsp";
	}
	
	@PostMapping("/new")
	public String pNewProduct(
		@Valid @ModelAttribute("newProduct") Product product,
		BindingResult result
		) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		} else {
			productService.createOrUpdateProduct(product);
			return "redirect:/";
		}
	}
	
	@PostMapping("/{productID}")
	public String pShowProduct(
		@PathVariable("productID") Long productID,
		@RequestParam("categoryID") Long categoryID) {
		categoryService.categorizeProduct(categoryID, productID);
		return "redirect:/products/" + productID;
	}

}
