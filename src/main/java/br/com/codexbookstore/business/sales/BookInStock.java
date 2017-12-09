package br.com.codexbookstore.business.sales;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.book.Book;
import br.com.codexbookstore.domain.sale.OrderItem;
import br.com.codexbookstore.domain.sale.ShopCart;
import br.com.codexbookstore.domain.stock.Stock;
import br.com.codexbookstore.persistence.dao.book.BookDAO;

public class BookInStock implements IStrategy {
    @Override
    public Result process(Entity entity, Result result) {
        OrderItem item = (OrderItem) entity;
        BookDAO bookDAO = new BookDAO();
        Stock bookStock = null;

        // get book id
        Long bookId = item.getBook().getId();

        // retrieve book from database
        Book book = (Book) bookDAO.retrieve("b.id = ".concat(String.valueOf(bookId))).get(0);

        // get book stock
        bookStock = book.getStock();

        // update book object with all fields filled
        item.setBook(book);

        if(bookStock.getAvailable() == 0) { //book out of stock?
            result.addErrorMsg("Book out of Stock");
        } else {
            result.setEntity(item);
        }

        return result;
    }
}
