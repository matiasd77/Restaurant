package Restaurant.Project.Restaurant.repository;

import Restaurant.Project.Restaurant.entity.Receipt_Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptProductRepo extends JpaRepository<Receipt_Product,Long> {
}
