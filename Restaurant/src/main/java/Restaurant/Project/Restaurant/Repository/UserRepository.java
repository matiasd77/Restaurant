package Restaurant.Project.Restaurant.Repository;

import Restaurant.Project.Restaurant.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);

    Optional<User> findByName(String name);
    Optional<User> findByRole(String surname);



}
