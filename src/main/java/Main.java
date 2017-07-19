import by.model.Department;
import by.model.Employee;
import by.model.Message;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Роман on 07.07.2017.
 */
public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
        session.beginTransaction();
        Employee employee=new Employee();
        File file=new File("D://2.png");
        byte[] bytes=new byte[(int) file.length()];
            FileInputStream fileInputStream=new FileInputStream(file);
            fileInputStream.read(bytes);
            fileInputStream.close();
            employee.setPhotoEmployee(bytes);
            employee.setName("Sasha");
            Department department= (Department) session.get(Department.class,1);
            employee.setDepartment(department);
            session.save(employee);
         session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}