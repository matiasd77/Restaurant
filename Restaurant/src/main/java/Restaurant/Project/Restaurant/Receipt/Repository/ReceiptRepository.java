package Restaurant.Project.Restaurant.Receipt.Repository;

import Restaurant.Project.Restaurant.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt,Integer> {

}
