package Restaurant.Project.Restaurant.Repository;

import Restaurant.Project.Restaurant.entity.Waiter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface WaiterRepository   extends JpaRepository <Waiter,Integer>{
        List<Waiter> findByName(String name);
    }

