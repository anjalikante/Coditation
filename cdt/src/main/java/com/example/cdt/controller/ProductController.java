package com.example.cdt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cdt.dto.ProductDTO;
import com.example.cdt.dto.Response;
import com.example.cdt.model.Category;
import com.example.cdt.model.Product;
import com.example.cdt.repository.ProductRepository;
import com.example.cdt.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/getAll")
	public List<ProductDTO> getAllProducts(){
		return productService.getAllProductsService();
	}
	
	@PostMapping(value = "/add")
	public Response addProduct(@RequestBody ProductDTO product) {
		Response response = new Response();
		
		Product newProduct = new Product();
		Category category = new Category();
		newProduct.setProduct_name(product.getProduct_name());
		newProduct.setCategory(product.getCategory());
		newProduct.setPrice(product.getPrice());
		try {
			System.out.println("---> ProductController : addProduct() : 1");
			productService.saveProductService(newProduct);
			response.setSuccess(true);
			response.setMessage("Product Saved Successfully");
			response.setResponse(newProduct);
		}catch (Exception e) {
			response.setSuccess(false);
			response.setMessage("Exception While saving product");
			response.setResponse(null);
			// TODO: handle exception
		}
		
		return response;
	}
	
	@GetMapping(value = "/byCategory/{category}")
	public List<ProductDTO> getProductByCategory(@PathVariable String category){
		
		System.out.println("getProductByCategory() : category :"+category);
		return productService.getProductByCategory(category);
	}
	
	@PutMapping(value = "/update")
	public Response updateProduct(@RequestBody ProductDTO product) {
		return productService.updateProduct(product);
	}
}
