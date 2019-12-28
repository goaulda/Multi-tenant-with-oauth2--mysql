package oauth2.multitenant.sboot.securitypanel.security.service;

import oauth2.multitenant.sboot.securitypanel.security.model.User;
import oauth2.multitenant.sboot.securitypanel.security.repo.UserRepoDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserServiceDAO implements UserDetailsService {


    @Autowired
    UserRepoDAO userRepoDAO;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepoDAO.findByUsername(s);

        if (user == null){
            throw new UsernameNotFoundException(String.format("User %s doesn`t exist", s));
        }

        System.out.println(String.format("User %s exist",s));
        return user;

    }
}
