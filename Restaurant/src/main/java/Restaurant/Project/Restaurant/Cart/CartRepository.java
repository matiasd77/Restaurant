package Restaurant.Project.Restaurant.Cart;

import Restaurant.Project.Restaurant.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
