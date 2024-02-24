package Restaurant.Project.Restaurant.Repository;

import Restaurant.Project.Restaurant.entity.Receipt_Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptProductRepository extends JpaRepository<Receipt_Product, Integer> {
}
