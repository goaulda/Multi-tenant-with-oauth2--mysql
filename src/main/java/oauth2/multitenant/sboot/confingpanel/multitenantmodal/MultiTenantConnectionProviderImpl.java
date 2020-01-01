package oauth2.multitenant.sboot.confingpanel.multitenantmodal;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class MultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

    @Value("${tenant.default}")
    private String dfTenant;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ApplicationContext applicationContext;

    private Map<String, DataSource> map = new HashMap<>();

    @PostConstruct
    public void load() {
        map.put(dfTenant, dataSource);
    }

    @Override
    protected DataSource selectAnyDataSource() {
        return map.get(dfTenant);
    }

    boolean init = false;

    @Override
    protected DataSource selectDataSource(String tenantIdentifier) {
        if (!init) {
            init = true;
            TenantDataSourceConfig tenantDataSourceConfig = applicationContext.getBean(TenantDataSourceConfig.class);
            map.putAll(tenantDataSourceConfig.getAll());
        }
        return map.get(tenantIdentifier) != null ? map.get(tenantIdentifier) : map.get(dfTenant);
    }
}
