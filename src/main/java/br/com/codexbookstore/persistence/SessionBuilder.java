package br.com.codexbookstore.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.PreDestroy;

public class SessionBuilder {
    private SessionFactory factory;
    private Session session;

    public SessionBuilder() {
        this.factory = SessionFactoryBuilder.getFactory();
        this.session = factory.openSession();
    }

    public Session getInstance() {
        return session;
    }

    @PreDestroy
    public void closeConnection() {
        session.close();
    }

}
