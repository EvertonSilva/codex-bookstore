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
        ShopCart cart = (ShopCart) entity;
        BookDAO bookDAO = new BookDAO();
        OrderItem item = null;
        Stock bookStock = null;

        for(int i = 0, max = cart.getOrderItems().size(); i < max; i++) {
            item = cart.getOrderItemAt(i);
            Long bookId = item.getBook().getId();
            Book book = (Book) bookDAO.retrieve("b.id = ".concat(String.valueOf(bookId))).get(0);
            bookStock = book.getStock();
            item.setBook(book);

            if(bookStock.getAvailable() == 0) { //book out of stock?
                cart.removeItem(i);
                result.addErrorMsg("Book out of Stock");
            }
        }
        return result;
    }
}
