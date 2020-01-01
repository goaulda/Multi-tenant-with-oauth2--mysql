package oauth2.multitenant.sboot.resourcepanel.endpoints;

import oauth2.multitenant.sboot.resourcepanel.models.model.CustomerInfo;
import oauth2.multitenant.sboot.resourcepanel.services.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CustomerInfoController {

    @Autowired
    CustomerInfoService customerInfoService;

    @RequestMapping(name = "/customer-info", value = "/customer-info", method = RequestMethod.GET)
    public ResponseEntity<Page<CustomerInfo>> findAllCustomerInfo(Pageable pageable){
        Page<CustomerInfo> allCustomerInfo = customerInfoService.findAllCustomerInfo(pageable);
        return new ResponseEntity<>(allCustomerInfo, HttpStatus.OK);

    }

}
