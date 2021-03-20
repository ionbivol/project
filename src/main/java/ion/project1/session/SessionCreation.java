package ion.project1.session;

import ion.project1.consults.ConsultEntity;
import ion.project1.doctor.DoctorEntity;
import ion.project1.patient.PatientEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class SessionCreation {


    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {

            try {

                Properties properties = new Properties();
                properties.put(Environment.URL, DataBaseUtils.DB_URL);
                properties.put(Environment.USER, DataBaseUtils.DB_USER);
                properties.put(Environment.PASS, DataBaseUtils.DB_PASSWORD);
                properties.put(Environment.DIALECT, DataBaseUtils.DB_DIALECT);
                properties.put(Environment.DRIVER, DataBaseUtils.DB_DRIVER);

                Configuration configuration = new Configuration();
                configuration.setProperties(properties);
                configuration.addAnnotatedClass(PatientEntity.class);
                configuration.addAnnotatedClass(DoctorEntity.class);
                configuration.addAnnotatedClass(ConsultEntity.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings
                        (configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return sessionFactory;
    }
}