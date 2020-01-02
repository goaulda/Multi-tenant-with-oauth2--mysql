package oauth2.multitenant.sboot.resourcepanel.endpoints;

import oauth2.multitenant.sboot.resourcepanel.models.model.CustomerInfo;
import oauth2.multitenant.sboot.resourcepanel.services.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @RequestMapping(name = "/customer-info", value = "/customer-info", method = RequestMethod.POST)
    public ResponseEntity<?> addCustomerInfo(@RequestBody @Valid CustomerInfo customerInfo){
        Long id = customerInfoService.addCustomerInfo(customerInfo);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @RequestMapping(name = "/customer-info/{id}", value = "/customer-info/{id}", method = RequestMethod.GET)
    public ResponseEntity<CustomerInfo> getOneCustomerInfo(@PathVariable("id") Long id) throws Exception {
        CustomerInfo customerInfo = customerInfoService.getOneCustomerInfo(id);
        return new ResponseEntity<>(customerInfo, HttpStatus.OK);
    }

    @RequestMapping(name = "/customer-info/{id}", value = "/customer-info/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOneCustomerInfo(@PathVariable("id") Long id) throws Exception {
        customerInfoService.deleteOneCustomerInfo(id);
        return new ResponseEntity<>("Delete id: " + id, HttpStatus.OK);
    }
}
