package oauth2.multitenant.sboot.confingpanel.multitenantmodal.exception.tenantexception.check;

import oauth2.multitenant.sboot.confingpanel.multitenantmodal.exception.tenantexception.TenantIDNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CheckIfTenantIsNull {
    public void check(String tenantID) {
        if (tenantID == null) {
            throw new TenantIDNotFoundException("Tenant not found");
        }
    }
}
