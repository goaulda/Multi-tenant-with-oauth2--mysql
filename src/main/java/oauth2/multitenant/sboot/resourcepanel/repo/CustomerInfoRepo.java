package oauth2.multitenant.sboot.resourcepanel.repo;

import oauth2.multitenant.sboot.resourcepanel.models.model.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerInfoRepo extends JpaRepository<CustomerInfo, Long> {
}
