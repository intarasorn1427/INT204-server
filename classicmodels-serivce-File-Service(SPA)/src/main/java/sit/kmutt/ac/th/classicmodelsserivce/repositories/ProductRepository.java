package sit.kmutt.ac.th.classicmodelsserivce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.kmutt.ac.th.classicmodelsserivce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}
