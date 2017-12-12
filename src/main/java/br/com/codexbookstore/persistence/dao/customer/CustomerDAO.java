package br.com.codexbookstore.persistence.dao.customer;

import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.domain.customer.Customer;
import br.com.codexbookstore.persistence.SessionBuilder;
import br.com.codexbookstore.persistence.dao.AbstractDAO;
import org.hibernate.Session;

import java.util.List;

public class CustomerDAO {
    private Session session;

    public CustomerDAO() {
        SessionBuilder sessionBuilder = new SessionBuilder();
        session = sessionBuilder.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<DomainEntity> findAll() {
        return session.createCriteria(Customer.class).list();
    }

    public Customer findById(Long id) {
        assert session.isConnected();
        assert session.isOpen();
        return session.get(Customer.class, 1L);
    }
}
