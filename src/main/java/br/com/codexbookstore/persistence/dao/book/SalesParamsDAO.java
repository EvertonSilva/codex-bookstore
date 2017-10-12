package br.com.codexbookstore.persistence.dao.book;

import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.book.SaleParameterization;
import br.com.codexbookstore.persistence.dao.AbstractDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SalesParamsDAO extends AbstractDAO {
    private boolean isTransational;

    public SalesParamsDAO(Boolean isTransational) {
        this.isTransational = isTransational;
    }

    @Override
    public boolean create(Entity entity) {
        openConnection();

        SaleParameterization saleParams = (SaleParameterization) entity;
        String query = "INSERT INTO sales_parametrization (min_sale_limit, periodicity, periodicity_unit, created_at, updated_at)" +
                "VALUES (?,?,?,?,?)";

        try {
            ResultSet rs = null;
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, saleParams.getMinSaleLimit());
            stmt.setInt(2, saleParams.getPeriodicity());
            stmt.setString(3, saleParams.getPeriodicityUnit());
            stmt.setTimestamp(4, new java.sql.Timestamp(new java.util.Date().getTime()));
            stmt.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));

            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();

            if(rs.next()) {
                entity.setId(rs.getLong(1));
            }

            if(!isTransational) {
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(!isTransational) {
                closeConnection();
            }
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
