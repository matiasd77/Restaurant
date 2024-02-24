package Restaurant.Project.Restaurant.Product;

import Restaurant.Project.Restaurant.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
