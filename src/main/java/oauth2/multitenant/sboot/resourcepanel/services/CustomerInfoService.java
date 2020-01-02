package oauth2.multitenant.sboot.resourcepanel.services;

import oauth2.multitenant.sboot.confingpanel.exceptionmodal.localexception.exception.notfoundentity.NotFoundEntityException;
import oauth2.multitenant.sboot.resourcepanel.checkservice.CheckExistingCostumerInfo;
import oauth2.multitenant.sboot.resourcepanel.models.model.CustomerInfo;
import oauth2.multitenant.sboot.resourcepanel.repo.CustomerInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerInfoService {

    @Autowired
    CustomerInfoRepo customerInfoRepo;

    @Autowired
    CheckExistingCostumerInfo existingCostumerInfo;

    public Page<CustomerInfo> findAllCustomerInfo(Pageable pageable) {

      return customerInfoRepo.findAll(pageable);
    }

    public Long addCustomerInfo(CustomerInfo customerInfo) {

        return customerInfoRepo.save(customerInfo).getId();
    }

    public CustomerInfo getOneCustomerInfo(Long id) throws Exception {
        CustomerInfo customerInfo = customerInfoRepo.findById(id).orElseThrow(()-> new NotFoundEntityException("Entity does not exist"));
        return customerInfo;
    }

    public void deleteOneCustomerInfo(Long id) {
        existingCostumerInfo.checkIfExist(id);
        customerInfoRepo.deleteById(id);
    }

}
