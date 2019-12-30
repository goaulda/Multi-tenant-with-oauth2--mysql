package oauth2.multitenant.sboot.confingpanel.multitenantmodal.repo;

import oauth2.multitenant.sboot.confingpanel.multitenantmodal.model.DataSourceTenantConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataSourceTenantConfigRepo extends JpaRepository<DataSourceTenantConfig, Long> {

    DataSourceTenantConfig findByName(String name);

}
