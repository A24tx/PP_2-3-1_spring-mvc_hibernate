package web.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Service;
import web.model.User;

import java.util.Properties;

public class HibernateUtil {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mypersistence");


    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }


}
