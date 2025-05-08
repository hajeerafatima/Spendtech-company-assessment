package e_commerce.ecommerce.site.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import e_commerce.ecommerce.site.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

	//@Query("SELECT p FROM Product p WHERE p.category.id = ?1")
//	List<Product> findByCategoryId(Long categoryId);
	
	@Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
	List<Product> findByCategory(@Param("categoryId") Long categoryId);
}
