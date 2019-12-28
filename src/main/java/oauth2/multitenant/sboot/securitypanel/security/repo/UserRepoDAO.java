package oauth2.multitenant.sboot.securitypanel.security.repo;

import oauth2.multitenant.sboot.securitypanel.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepoDAO extends JpaRepository<User, Long> {


    @Query("SELECT DISTINCT user FROM User user " +
            "INNER JOIN FETCH user.roles AS authorities " +
            "WHERE user.username = :username")
    User findByUsername(@Param("username") String username);

}
