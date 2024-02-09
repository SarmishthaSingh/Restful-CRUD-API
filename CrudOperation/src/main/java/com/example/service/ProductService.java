package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repository.ProductRespository;



@Service
public class ProductService {
	@Autowired
	private ProductRespository repository;
	
	// Save Data
	public Product saveproduct(Product product){
        if (product.getName() == null || product.getName().isEmpty()) {
           throw new IllegalArgumentException("Product name cannot be null or empty"); 
           // return new ResponseEntity<>("Product name cannot be null or empty", HttpStatus.BAD_REQUEST);
        }
        if (product.getPrice()>0) {
            throw new IllegalArgumentException("Price must be a positive value");
        }
        return repository.save(product);
	}
	
	public List<Product> saveproducts(List<Product> products)
	{
		return repository.saveAll(products);
	}
	
	// Get Data
	
	public Product getProductById(int id)
	{
		return repository.findById(id).orElse(null);	
	}
	public List<Product> getProducts(){
		return repository.findAll();
	}
	
	// Delete Data
	
	public String deleteProduct(int id)
	{
		repository.deleteById(id);
		return "Product Deleted"+id;
	}
	
	// Update Data
	
	public Product updateProduct(Product product) {
		Product existingProduct=repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
		
	}

}

















