package oauth2.multitenant.sboot.confingpanel.multitenantmodal;

public class TenantContext {

    private static ThreadLocal<String> contextTenant = new InheritableThreadLocal<>();

    public static String getCurrentTenant() {

        return contextTenant.get();
    }

    public static void setCurrentTenant(String tenant) {
        contextTenant.set(tenant);
    }

    public static void clear() {
        contextTenant.set(null);
    }


}
