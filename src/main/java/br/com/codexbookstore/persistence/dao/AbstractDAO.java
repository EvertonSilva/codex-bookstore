package br.com.codexbookstore.persistence.dao;

import br.com.codexbookstore.persistence.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDAO implements IDAO {

    protected Connection conn;

    public void openConnection() {
        conn = new ConnectionFactory().getConnection();
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
