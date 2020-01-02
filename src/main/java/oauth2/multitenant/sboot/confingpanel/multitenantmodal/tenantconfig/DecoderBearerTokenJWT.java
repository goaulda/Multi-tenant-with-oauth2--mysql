package oauth2.multitenant.sboot.confingpanel.multitenantmodal.tenantconfig;

import oauth2.multitenant.sboot.confingpanel.exceptionmodal.localexception.exception.notagreeingusername.NotAgreeingUsernameException;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class DecoderBearerTokenJWT {

    Logger logger = LoggerFactory.getLogger(DecoderBearerTokenJWT.class);

    public String decodeJWT(String bearer, HttpServletRequest request) {

        String body = extractorJWTMethod(bearer);
        String extractUserName = extractUserNameFromBodyToken(body);
        String principal = request.getUserPrincipal().getName();
        checkPrincipal(extractUserName, principal);
        logger.info(String.valueOf(extractUserName));

        return principal;
    }

    private void checkPrincipal(String extractUserName, String principal) {
        logger.info(extractUserName+" , "+ principal);
        if (extractUserName.hashCode()!=principal.hashCode()){
            throw new NotAgreeingUsernameException("Disagreeing username");
        }
    }

    private String extractUserNameFromBodyToken(String body) {
        String name = "user_name";
        int indexOfUsername = body.lastIndexOf(name);
        int indexOfLastCharUserName = body.indexOf("scope");
        String username = body.substring(indexOfUsername+name.length()+3, indexOfLastCharUserName-3);
        return username;
    }

    private String extractorJWTMethod(String bearer) {
        String jwtToken = bearer.substring(7) ;
        logger.info(jwtToken);
        String[] split_string = jwtToken.split("\\.");
        String base64EncodedHeader = split_string[0];
        String base64EncodedBody = split_string[1];
        Base64 base64Url = new Base64(true);
        String header = new String(base64Url.decode(base64EncodedHeader));
        String body = new String(base64Url.decode(base64EncodedBody));
        return body;
    }
}
