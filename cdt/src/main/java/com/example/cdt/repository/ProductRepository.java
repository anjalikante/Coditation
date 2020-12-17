package com.example.cdt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.cdt.model.Category;
import com.example.cdt.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	public List<Product> findByCategory(Category category);
	
//	@Query("Select p from Product p where p.category = :category")
//	public List<Product> findByCategoryID(@Param("category") Category category);
	
	@Query("Select p from Product p where p.category = :category")
	public List<Product> findByCategoryID(@Param("category") Category category);
	
}
