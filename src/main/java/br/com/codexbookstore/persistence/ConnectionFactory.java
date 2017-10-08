package br.com.codexbookstore.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private final String DBURL = "jdbc:h2:file:/home/everton/Projetos/les/codex-bookstore/src/main/resources/data/codex";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(DBURL, "sa", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
