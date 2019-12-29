package oauth2.multitenant.sboot.resourcepanel.endpoints;

import oauth2.multitenant.sboot.resourcepanel.endpoints.model.InfoUser;
import org.omg.Dynamic.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import java.security.Principal;

@RequestMapping
@RestController
public class InfoController {

    @Autowired
    InfoUser infoUser;

    @RequestMapping(value = "/userInfo", name = "/userInfo", method = RequestMethod.GET)
    public ResponseEntity<?> getInfoAboutUser(Principal principal, ServletRequest request){

        infoUser.setUsername(principal.getName());
        infoUser.setIp(request.getLocalAddr());
        infoUser.setDatetime(request.getRemoteAddr());
        return new ResponseEntity<>(infoUser,HttpStatus.OK);
    }


}
