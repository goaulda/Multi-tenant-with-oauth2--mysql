package oauth2.multitenant.sboot.confingpanel.multitenantmodal.check;

import oauth2.multitenant.sboot.confingpanel.exceptionmodal.localexception.exception.tenantexception.TenantIDNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CheckIfTenantIsNull {
    public void check(String tenantID) {
        if (tenantID == null) {
            throw new TenantIDNotFoundException("Tenant not found");
        }
    }
}
