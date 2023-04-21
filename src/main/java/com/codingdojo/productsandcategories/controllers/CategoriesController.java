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

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.services.CategoryService;
import com.codingdojo.productsandcategories.services.ProductService;

@Controller
@RequestMapping("/categories")
public class CategoriesController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@GetMapping("/new")
	public String rNewCategory (@ModelAttribute("newCategory") Category category) {
		return "newCategory.jsp";
	}
	
	@GetMapping("/{categoryID}")
	public String rShowCategory (
		Model model,
		@PathVariable("categoryID") Long categoryID) {
		Category thisCategory = categoryService.findCategoryByID(categoryID);
		model.addAttribute("thisCategory", thisCategory);
		model.addAttribute("assignedProducts", productService.getAllAssignedProductsOfCategory(thisCategory));
		model.addAttribute("unassignedProducts", productService.getAllUnassignedProductsOfCategory(thisCategory));
		return "showCategory.jsp";
	}
	
	@PostMapping("/new")
	public String pNewCategory(
		@Valid @ModelAttribute("newCategory") Category category,
		BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		} else {
			categoryService.createOrUpdateCategory(category);
			return "redirect:/";
		}
	}
	
	@PostMapping("/{categoryID}")
	public String pShowCategory (
		@PathVariable("categoryID") Long categoryID,
		@RequestParam("productID") Long productID) {
		categoryService.categorizeProduct(categoryID, productID);
		return "redirect:/categories/" + categoryID;
	}

}
