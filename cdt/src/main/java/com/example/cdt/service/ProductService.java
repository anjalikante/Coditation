package com.example.cdt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.cdt.dto.ProductDTO;
import com.example.cdt.dto.Response;
import com.example.cdt.model.Category;
import com.example.cdt.model.Product;
import com.example.cdt.repository.CategoryRepository;
import com.example.cdt.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository prodRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<ProductDTO> getAllProductsService() {
		
		List<ProductDTO> dtoList = new ArrayList<ProductDTO>();
		List<Product> productList  = prodRepository.findAll();
		
		productList.forEach( product ->{
			ProductDTO prodDTO = new ProductDTO();
			prodDTO.setProduct_name(product.getProduct_name());
			prodDTO.setPrice(product.getPrice());
			prodDTO.setId(product.getId());
			
			dtoList.add(prodDTO);
		});
		
		//return prodRepository.findAll();
		return dtoList;
	}
	
	public void saveProductService(Product product) {
		prodRepository.save(product);
	}
	
	public List<ProductDTO> getProductByCategory(String category) {
		
		List<ProductDTO> dtoList = new ArrayList<ProductDTO>();
		
		Category categoryObj= categoryRepository.findBycategoryName(category);
		
		System.out.println("categoryObj :" +categoryObj.getCategoryName());
		List<Product> productList = prodRepository.findByCategory(categoryObj);
		System.out.println("productList : size :" + productList.size());
		
		productList.forEach( product ->{
			ProductDTO prodDTO = new ProductDTO();
			prodDTO.setProduct_name(product.getProduct_name());
			prodDTO.setPrice(product.getPrice());
			prodDTO.setId(product.getId());
			
			dtoList.add(prodDTO);
		});
		return dtoList;
	}
	
	public Response updateProduct(ProductDTO product) {
		Response response = new Response();
		Optional<Product> prod = prodRepository.findById(product.getId());
		
		if(prod.isPresent()) {
			Product newProd = prod.get();
				newProd.setPrice(product.getPrice());
				newProd.setProduct_name(product.getProduct_name());
				
			prodRepository.save(newProd);
		
			response.setSuccess(true);
			response.setMessage("Product Updated Successfully!");
		}
		else {
			response.setSuccess(false);
			response.setMessage("error while updating");
		}
		return response;
	}
}
