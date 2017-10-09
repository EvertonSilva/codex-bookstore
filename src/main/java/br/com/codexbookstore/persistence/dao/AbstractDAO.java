package br.com.codexbookstore.persistence.dao;

import br.com.codexbookstore.persistence.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO implements IDAO {

    protected Connection conn;

    protected void openConnection() {
        conn = new ConnectionFactory().getConnection();
    }

    protected void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to retrieve the last ID inserted on
     * any insert operation
     */
    public Long getLastInsertID() {
        String query = "SELECT LAST_INSERT_ID() as last_id";
        Long lastId;
        try {
            ResultSet rs;
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            rs.next();
            lastId = rs.getLong("last_id");
            stmt.close();
            return lastId;
        } catch (SQLException e) {
            closeConnection();
            throw new RuntimeException(e);
        }
    }
}
