package by.DAO;

import by.modelSecurity.UsersEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by Роман on 17.07.2017.
 */
@Repository
public class DAOUser {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void saveUser(UsersEntity usersEntity){
        this.sessionFactory.getCurrentSession().persist(usersEntity);
    }
    public UsersEntity getUserById(int id){
        UsersEntity usersEntity= (UsersEntity) this.sessionFactory.getCurrentSession().get(UsersEntity.class,id);
        return usersEntity;
    }
    public UsersEntity getUserByUsername(String username){
        Session session=this.sessionFactory.getCurrentSession();
        Query query=session.createQuery("from UsersEntity where username=:username");
        query.setString("username",username);
        UsersEntity usersEntity= (UsersEntity) query.uniqueResult();
        return usersEntity;
    }
}
