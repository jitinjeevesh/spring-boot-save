package sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.domain.AuthenticationToken;
import sample.domain.User;

public interface AuthenticationTokenRepository extends JpaRepository<AuthenticationToken, Long> {
}
