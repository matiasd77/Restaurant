package Restaurant.Project.Restaurant.repo;

import Restaurant.Project.Restaurant.entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {

}
