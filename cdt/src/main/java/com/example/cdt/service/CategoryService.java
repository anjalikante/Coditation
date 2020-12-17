package com.example.cdt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cdt.dto.CategoryDTO;
import com.example.cdt.dto.Response;
import com.example.cdt.model.Category;
import com.example.cdt.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository catRepository;
	
	public List<Category> getAllCategories(){
		return catRepository.findAll();
	}
	
	public Response addCategories(CategoryDTO categoryDTO) {
		Response response = new Response();
		
		try {
			
			Category newCategory = new Category();
			newCategory.setCategoryName(categoryDTO.getCategoryName());
			if(categoryDTO.getParent()!=null) {
				newCategory.setParent(categoryDTO.getParent());
			}
			else {
				newCategory.setParent(null);
			}
			
			catRepository.save(newCategory);
			response.setSuccess(true);
			response.setMessage("Category Saved Successfully");
			response.setResponse(newCategory);
		}catch (Exception e) {
			response.setSuccess(false);
			response.setMessage("Exception While saving category");
			response.setResponse(null);
		}
		return response;
	}
}
