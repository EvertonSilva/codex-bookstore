package br.com.codexbookstore.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private String dbName = "codex";
    private String dbPath = "/home/everton/Projetos/les/codex-bookstore/src/main/resources/data/";
    private String dbUser = "gutenberg";
    private String dbPass = "letter4thepeople";
    private String dbMode = "AUTO_SERVER=TRUE";
    private final StringBuilder DBURL = new StringBuilder("jdbc:h2:file:");
//    private final String DBURL = "jdbc:h2:file:/home/everton/Projetos/les/codex-bookstore/src/main/resources/data/codex";


    public ConnectionFactory() {
        DBURL.append(dbPath);
        DBURL.append(dbName);
        DBURL.append(";");
        DBURL.append(dbMode);
    }

    public Connection getConnection() {
        try {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection(DBURL.toString(), dbUser, dbPass);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
