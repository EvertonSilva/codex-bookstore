package br.com.codexbookstore.business.sales;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.book.Book;
import br.com.codexbookstore.domain.sale.ShopCart;
import br.com.codexbookstore.persistence.dao.book.BookDAO;

public class BookInStock implements IStrategy {
    @Override
    public Result process(Entity entity, Result result) {
        ShopCart cart = (ShopCart) entity;
        BookDAO bookDAO = new BookDAO();

        for(int i = 0, max = cart.getOrderItems().size(); i < max; i++) {
            Long bookId =  cart.getOrderItemAt(i).getBook().getId();
            Book book = (Book) bookDAO.retrieve("b.id = ".concat(String.valueOf(bookId))).get(0);

            cart.getOrderItemAt(i).setBook(book);
        }
        return result;
    }
}
