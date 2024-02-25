package Restaurant.Project.Restaurant.Repository;

import Restaurant.Project.Restaurant.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where p.price = (select MAX(p1.price) from Product p1)")
    Optional<Product> findByMaxPrice();

    @Query("select  p from Product  p where p.price = (select  MIN(p1.price) from Product  p1)")
    Optional<Product> findByMinPrice();

}
