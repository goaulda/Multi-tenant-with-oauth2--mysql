package oauth2.multitenant.sboot.confingpanel.multitenantmodal;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//Checks which schema name should be used. If there is no schema name, it inserts the default schema, where the tables responsible for oauth2 authorization are located.
//If validateExistingCurrentSessions is set to true, multi-tenant works on the basis of session.
@Component
public class TenantSchemaResolver implements CurrentTenantIdentifierResolver {

    @Value("${tenant.default}")
    private String dfTenant;

    @Override
    public String resolveCurrentTenantIdentifier() {

        String currently = TenantContext.getCurrentTenant();;
        if(currently == null){
            return dfTenant;
        }
        return currently;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
