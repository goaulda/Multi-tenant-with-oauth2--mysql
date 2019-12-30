package oauth2.multitenant.sboot.confingpanel.multitenantmodal.datasourceconfig;

import oauth2.multitenant.sboot.confingpanel.multitenantmodal.datasourceconfig.model.DataSourceTenantConfig;
import oauth2.multitenant.sboot.confingpanel.multitenantmodal.datasourceconfig.repo.DataSourceTenantConfigRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TenantDataSourceConfig implements Serializable {

    private HashMap<String, DataSource> dataSources = new HashMap<>();

    @Autowired
    private DataSourceTenantConfigRepo configRepo;

    public DataSource getDataSource(String name) {
        if (dataSources.get(name) != null) {
            return dataSources.get(name);
        }
        DataSource dataSource = createDataSource(name);
        if (dataSource != null) {
            dataSources.put(name, dataSource);
        }
        return dataSource;
    }

    @PostConstruct
    public Map<String, DataSource> getAll() {
        List<DataSourceTenantConfig> configList = configRepo.findAll();
        Map<String, DataSource> result = new HashMap<>();
        for (DataSourceTenantConfig config : configList) {
            DataSource dataSource = getDataSource(config.getNameTenant());
            result.put(config.getNameTenant(), dataSource);
        }
        return result;
    }

    private DataSource createDataSource(String name) {
        DataSourceTenantConfig config = configRepo.findByName(name);
        if (config != null) {
            DataSourceBuilder factory = DataSourceBuilder
                    .create().driverClassName(config.getDriver())
                    .username(config.getUsername())
                    .password(config.getPassword())
                    .url(config.getUrlName());
            DataSource ds = factory.build();
            return ds;
        }
        return null;
    }
}
