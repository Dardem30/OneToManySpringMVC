package by.service;

import by.DAO.DAOUser;
import by.modelSecurity.RolesEntity;
import by.modelSecurity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Роман on 17.07.2017.
 */

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    @Qualifier("serviceUser")
    private ServiceUser serviceUser;

    public void setServiceUser(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity usersEntity=serviceUser.getUserByUsername(username);
        Set<GrantedAuthority> grantedAuthorities=new HashSet<>();
        for(RolesEntity r: usersEntity.getRolesEntitySet()){
            grantedAuthorities.add(new SimpleGrantedAuthority(r.getName()));
        }
        return new org.springframework.security.core.userdetails.User(usersEntity.getUsername(),
                usersEntity.getPassword(),
                grantedAuthorities);
    }
}
