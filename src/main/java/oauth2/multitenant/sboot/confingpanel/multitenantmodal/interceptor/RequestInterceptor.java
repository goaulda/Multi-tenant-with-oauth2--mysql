package oauth2.multitenant.sboot.confingpanel.multitenantmodal.interceptor;

import oauth2.multitenant.sboot.confingpanel.multitenantmodal.tenantconfig.DecoderBearerTokenJWT;
import oauth2.multitenant.sboot.confingpanel.multitenantmodal.tenantconfig.TenantContext;
import oauth2.multitenant.sboot.confingpanel.multitenantmodal.check.CheckIfTenantIsNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    @Autowired
    CheckIfTenantIsNull checkIfTenantIsNull;

    @Autowired
    DecoderBearerTokenJWT decoderBearerTokenJWT;


    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object object) throws Exception {
        String requestURI = request.getRequestURI();
        String bearer = request.getHeader("Authorization");

        String tenantID = decoderBearerTokenJWT.decodeJWT(bearer, request);
        logger.info("Url:" + requestURI +", from Tenant: " + tenantID);
        checkIfTenantIsNull.check(tenantID);
        TenantContext.setCurrentTenant(tenantID);
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        TenantContext.clear();
    }

}
