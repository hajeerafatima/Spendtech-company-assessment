package e_commerce.ecommerce.site.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import e_commerce.ecommerce.site.model.Product;
import e_commerce.ecommerce.site.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public List<Product> getProductByCategory(Long categoryId) {
		return productRepository.findAll();
	}

	public Optional<Product> findById(Long id) {
	    return productRepository.findById(id);
	}

	
}
