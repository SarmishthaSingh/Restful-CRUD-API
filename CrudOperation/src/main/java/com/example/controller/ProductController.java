package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Product;
import com.example.service.ProductService;
import jakarta.websocket.server.PathParam;

@RestController
public class ProductController {
 @Autowired
	private ProductService service;
     
 
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product)
    {
    	return service.saveproduct(product);
    }
    
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product>products)
    {
    	return service.saveproducts(products);
    }
	
    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable int id)
    {
    	return service.getProductById(id);
    }
    
    @GetMapping("/products")
    public List<Product> findAllProducts()
    {
    	return service.getProducts();
    }
    
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product)
    {
    	return service.updateProduct(product);
    	
    }
    
    @DeleteMapping("/delete/id")
   public String deleteProduct(@PathVariable int id)
   {
	   return service.deleteProduct(id);
   }
}
























