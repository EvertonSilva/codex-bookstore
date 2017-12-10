package br.com.codexbookstore.persistence;


import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.annotation.PreDestroy;

public final class SessionFactoryBuilder {
    private static SessionFactory factory;

    // to disalow create objects
    private SessionFactoryBuilder() {}

    static synchronized SessionFactory getFactory() {
        if(factory == null) {
            // factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }
        return factory;
    }

    @PreDestroy
    public void closeConnections() {
        factory.close();
    }

}
