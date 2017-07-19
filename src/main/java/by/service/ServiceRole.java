package by.service;

import by.DAO.DAORole;
import by.modelSecurity.RolesEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Роман on 17.07.2017.
 */
@Service
public class ServiceRole {
    private DAORole role;

    public void setRole(DAORole role) {
        this.role = role;
    }
    @Transactional
    public void saveRole(RolesEntity rolesEntity){
       this.role.saveRole(rolesEntity);
    }
    @Transactional
    public RolesEntity getRoleById(int id){
        return this.role.getRoleById(id);
    }
}
