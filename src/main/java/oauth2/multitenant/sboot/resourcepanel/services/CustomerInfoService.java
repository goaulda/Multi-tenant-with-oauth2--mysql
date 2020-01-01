package oauth2.multitenant.sboot.resourcepanel.services;

import oauth2.multitenant.sboot.resourcepanel.models.model.CustomerInfo;
import oauth2.multitenant.sboot.resourcepanel.repo.CustomerInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerInfoService {

    @Autowired
    CustomerInfoRepo customerInfoRepo;

    public Page<CustomerInfo> findAllCustomerInfo(Pageable pageable) {

      return customerInfoRepo.findAll(pageable);
    }
}
