package oauth2.multitenant.sboot.confingpanel.multitenantmodal.datasourceconfig.repo;

import oauth2.multitenant.sboot.confingpanel.multitenantmodal.datasourceconfig.model.DataSourceTenantConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface DataSourceTenantConfigRepo extends JpaRepository<DataSourceTenantConfig, Long> {

    DataSourceTenantConfig findByNameTenant(String nameTenant);

}
