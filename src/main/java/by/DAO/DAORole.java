package by.DAO;

import by.modelSecurity.RolesEntity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by Роман on 17.07.2017.
 */
@Repository
public class DAORole {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void saveRole(RolesEntity rolesEntity){
        this.sessionFactory.getCurrentSession().persist(rolesEntity);
    }
    public RolesEntity getRoleById(int id){
        RolesEntity rolesEntity= (RolesEntity) this.sessionFactory.getCurrentSession().get(RolesEntity.class,id);
        return rolesEntity;
    }
}
