package oauth2.multitenant.sboot.confingpanel.multitenantmodal;

import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class TenantConnectionProvider implements MultiTenantConnectionProvider {

    @Value("${tenant.default}")
    private String defaultNameTenant;

    private DataSource dataSource;

    public TenantConnectionProvider(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Connection getAnyConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public Connection getConnection(String s) throws SQLException {
        final Connection c = getAnyConnection();
        c.setSchema(s);
        //System.out.println(String.format("Get connection for tenant %c", c));
        return c;

    }

    @Override
    public void releaseConnection(String s, Connection connection) throws SQLException {

        connection.setSchema(defaultNameTenant);
        releaseAnyConnection(connection);
        //System.out.println(String.format("Release connection %s", s));

    }

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    @Override
    public boolean isUnwrappableAs(Class aClass) {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> aClass) {
        return null;
    }
}
