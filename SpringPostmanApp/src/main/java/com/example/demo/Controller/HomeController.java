package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class HomeController {

	@Autowired
	private ProductService service;

	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) {

		return service.saveProduct(product);

	}

	@PostMapping("/addproducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {

		return service.saveProducts(products);

	}

	@GetMapping("/getproducts")
	public List<Product> findAllProducts() {

		return service.getProducts();

	}

	@GetMapping("/productid/{id}")
	public Product findProductbyId(@PathVariable int id) {

		return service.getProductsById(id);
	}

	@PutMapping("/updateproduct")
	public Product updateproduct(@RequestBody Product product) {

		return service.updateProduct(product);

	}

	@DeleteMapping("/deleteproduct/{id}")
	public String deleteproduct(@PathVariable int id) {

		return service.deleteProduct(id);
	}
}
