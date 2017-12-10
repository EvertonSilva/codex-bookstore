package br.com.codexbookstore;

import br.com.codexbookstore.domain.customer.Customer;
import br.com.codexbookstore.persistence.SessionBuilder;
import br.com.codexbookstore.persistence.dao.customer.CustomerDAO;
import org.hibernate.Session;

/**
 * Created by everton on 10/12/17.
 */
public class TestTestTest {

    public static void main(String[] args) {
//        SessionBuilder sessionBuilder = new SessionBuilder();
//        Session session = sessionBuilder.getInstance();
//        Customer customer = session.get(Customer.class, 1L);
        CustomerDAO dao = new CustomerDAO();
        Customer customer = dao.findById(1L);
        System.out.println(customer.getName());
    }
}
