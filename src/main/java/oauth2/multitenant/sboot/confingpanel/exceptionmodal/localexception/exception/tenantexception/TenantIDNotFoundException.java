package oauth2.multitenant.sboot.confingpanel.exceptionmodal.localexception.exception.tenantexception;

public class TenantIDNotFoundException extends RuntimeException {

    public TenantIDNotFoundException() {
    }

    public TenantIDNotFoundException(String s) {
        super(s);
    }

    public TenantIDNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public TenantIDNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public TenantIDNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
