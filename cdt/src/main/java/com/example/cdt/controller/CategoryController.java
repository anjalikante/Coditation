package com.example.cdt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cdt.dto.CategoryDTO;
import com.example.cdt.dto.Response;
import com.example.cdt.model.Category;
import com.example.cdt.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService; 
	
	@GetMapping(value = "/getAll")
	public List<Category> getAllCategories(){
		return categoryService.getAllCategories();
	}

	@PostMapping(value = "/add")
	public Response addCategory(@RequestBody CategoryDTO categoryDTO) {
		return categoryService.addCategories(categoryDTO);
	}
}
