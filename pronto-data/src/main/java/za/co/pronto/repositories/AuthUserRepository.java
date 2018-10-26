package za.co.pronto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.pronto.model.AuthUser;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {

    AuthUser findAuthUserByUsername(String username);
}
