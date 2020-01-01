package oauth2.multitenant.sboot.confingpanel.multitenantmodal;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DecoderBearerTokenJWT {

    Logger logger = LoggerFactory.getLogger(DecoderBearerTokenJWT.class);

    public String decodeJWT(String bearer) {

        String jwtToken = bearer.substring(7) ;
        logger.info(jwtToken);
        String[] split_string = jwtToken.split("\\.");
        String base64EncodedHeader = split_string[0];
        String base64EncodedBody = split_string[1];

        Base64 base64Url = new Base64(true);
        String header = new String(base64Url.decode(base64EncodedHeader));

        String body = new String(base64Url.decode(base64EncodedBody));

        int first = body.lastIndexOf("\"aud\":[\"");

        String tenantID = body.substring(first);

        logger.info(String.valueOf(first));
        logger.info(tenantID);

        return body;
    }
}
