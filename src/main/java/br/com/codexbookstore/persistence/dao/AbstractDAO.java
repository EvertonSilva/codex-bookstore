package br.com.codexbookstore.persistence.dao;

import br.com.codexbookstore.persistence.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO implements IDAO {

    protected Connection conn = null;
    private static Connection transaction = null;

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

    public Connection getTransaction() {
        return transaction;
    }

    public void setTransaction(Connection connection) {
        transaction = connection;
    }
}
