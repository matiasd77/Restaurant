package Restaurant.Project.Restaurant.Repository;

import Restaurant.Project.Restaurant.entity.ReceiptProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptProductRepository extends JpaRepository<ReceiptProduct, Integer> {
}
