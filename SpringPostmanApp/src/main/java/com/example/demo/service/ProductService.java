package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.advice.ErrorDetails;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productrepository;

	
	
	public Product saveProduct(Product product) {
		
		if(product.getName().isEmpty() || product.getName().length()== 0 ) {
			
			throw new ErrorDetails();
			
		}
			return productrepository.save(product);

}

	public List<Product> saveProducts(List<Product> products) {

       return productrepository.saveAll(products);

	}

	public List<Product> getProducts() {

		return productrepository.findAll();

	}

	public Product getProductsById(int id) {

		return productrepository.findById(id).orElse(null);

	}

	public String deleteProduct(int id) {

		productrepository.deleteById(id);

		return "product delete !! " + id;
	}

	public Product updateProduct(Product product) {

		Product exsitingproduct = productrepository.findById(product.getId()).orElse(null);
		exsitingproduct.setId(product.getId());
		exsitingproduct.setName(product.getName());

		return productrepository.save(product);
	}
}
