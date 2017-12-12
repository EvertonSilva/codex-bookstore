package br.com.codexbookstore.persistence.dao.book;


import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.domain.book.Book;
import br.com.codexbookstore.persistence.dao.AbstractDAO;
import com.sun.java.browser.plugin2.DOM;

import java.sql.SQLException;
import java.util.List;

public class BookDAO extends AbstractDAO {


    public BookDAO() {
    }

    @Override
    public Long save(DomainEntity entity) {
        Book book = (Book) entity;
        Long id = null;
        try {
            session.getTransaction().begin();
            id = (Long) session.save(book);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<DomainEntity> findAll() {
        return session.createCriteria(Book.class).list();
    }

    @Override
    public DomainEntity findById(Long id) {
        return session.get(Book.class, id);
    }

    @Override
    public boolean update(DomainEntity entity) {
        Book book = (Book) entity;
        try {
            session.getTransaction().begin();
            session.update(book);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(DomainEntity entity) {
        Book book = (Book) entity;
        try {
            session.getTransaction().begin();
            session.delete(book);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
