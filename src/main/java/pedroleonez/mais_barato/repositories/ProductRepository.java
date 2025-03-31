package pedroleonez.mais_barato.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pedroleonez.mais_barato.models.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
