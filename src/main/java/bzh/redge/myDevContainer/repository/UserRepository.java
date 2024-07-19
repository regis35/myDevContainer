package bzh.redge.myDevContainer.repository;

import bzh.redge.myDevContainer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
