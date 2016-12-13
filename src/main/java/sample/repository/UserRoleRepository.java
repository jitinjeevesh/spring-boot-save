package sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.domain.User;
import sample.domain.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
