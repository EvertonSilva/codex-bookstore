package br.com.codexbookstore.persistence.dao.book;


import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.domain.book.Book;
import br.com.codexbookstore.persistence.SessionBuilder;
import br.com.codexbookstore.persistence.dao.IDAO;
import org.hibernate.Session;

import java.util.List;

public class BookDAO implements IDAO {
    private Session session;

    public BookDAO() {
        SessionBuilder sessionBuilder = new SessionBuilder();
        session = sessionBuilder.getInstance();
    }

    @Override
    public boolean create(DomainEntity domainEntity) {
        Long id = (Long) session.save(castBook(domainEntity));
        return id != null; // id == null -> save fails!
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<DomainEntity> retrieve(String queryModifiers) {
        List<DomainEntity> books = session.createCriteria(Book.class).list();
        return books;
    }

    @Override
    public boolean update(DomainEntity domainEntity) {
        return false;
    }

    @Override
    public boolean delete(DomainEntity domainEntity) {
        return false;
    }

    private Book castBook(DomainEntity entity) {
        return (Book) entity;
    }
}
