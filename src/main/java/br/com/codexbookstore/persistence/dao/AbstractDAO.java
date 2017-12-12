package br.com.codexbookstore.persistence.dao;

import br.com.codexbookstore.persistence.SessionBuilder;
import org.hibernate.Session;

public abstract class AbstractDAO implements IDAO {
    protected Session session;

    public AbstractDAO() {
        SessionBuilder sessionBuilder = new SessionBuilder();
        session = sessionBuilder.getInstance();
    }
}
