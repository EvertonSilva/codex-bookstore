package br.com.codexbookstore.persistence.dao.book;

import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.stock.Stock;
import br.com.codexbookstore.persistence.dao.AbstractDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockDAO extends AbstractDAO {
    @Override
    public boolean create(Entity entity) {
        return false;
    }

    @Override
    public List<Entity> retrieve(String queryModifiers) {
        openConnection();

        List<Entity> stockList = new ArrayList<>();
        StringBuilder query = new StringBuilder();

        query.append("SELECT * FROM stocks ");
        query.append("WHERE ");
        query.append(queryModifiers);

        try {
            ResultSet rs = null;
            PreparedStatement stmt = conn.prepareStatement(query.toString());
            rs = stmt.executeQuery();

            while(rs.next()) {
                Stock stock = new Stock();

                stock.setId(rs.getLong("id"));
                stock.setQuantity(rs.getInt("quantity"));
                stock.setPurchasePrice(rs.getBigDecimal("purchase_price"));

                stockList.add(stock);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stockList;
    }

    @Override
    public boolean update(Entity entity) {
        return false;
    }

    @Override
    public boolean delete(Entity entity) {
        return false;
    }
}
