package oauth2.multitenant.sboot.resourcepanel.checkservice;

import oauth2.multitenant.sboot.confingpanel.exceptionmodal.localexception.exception.notfoundentity.NotFoundEntityException;
import oauth2.multitenant.sboot.resourcepanel.models.model.CustomerInfo;
import oauth2.multitenant.sboot.resourcepanel.repo.CustomerInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckExistingCostumerInfo {

    @Autowired
    CustomerInfoRepo customerInfoRepo;

    public void checkIfExist(Long id) {
        customerInfoRepo.findById(id).orElseThrow(()-> new NotFoundEntityException("Entity not exist"));
    }
}
