package br.com.codexbookstore.persistence.dao.book;

import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.book.SaleParameterization;
import br.com.codexbookstore.persistence.dao.AbstractDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SalesParamsDAO extends AbstractDAO {
    @Override
    public boolean create(Entity entity) {
        openConnection();

        SaleParameterization saleParams = (SaleParameterization) entity;
        String query = "INSERT INTO sales_parametrization (min_sale_limit, periodicity, periodicity_unit, created_at, updated_at)" +
                "VALUES (?,?,?,?,?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, saleParams.getMinSaleLimit());
            stmt.setInt(2, saleParams.getPeriodicity());
            stmt.setString(3, saleParams.getPeriodicityUnit());
            stmt.setTimestamp(4, new java.sql.Timestamp(new java.util.Date().getTime()));
            stmt.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
        return true;
    }

    @Override
    public List<Entity> retrieve() {
        return null;
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
