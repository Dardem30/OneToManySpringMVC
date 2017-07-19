package by.service;

import by.DAO.DAOUser;
import by.modelSecurity.UsersEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Роман on 17.07.2017.
 */
@Service
public class ServiceUser {
    private DAOUser user;

    public void setUser(DAOUser user) {
        this.user = user;
    }
    @Transactional
    public void saveUser(UsersEntity usersEntity){
        this.user.saveUser(usersEntity);
    }
    @Transactional
    public UsersEntity getUserById(int id){
        return this.user.getUserById(id);
    }
    @Transactional
    public UsersEntity getUserByUsername(String username){
        return this.user.getUserByUsername(username);
    }
}
