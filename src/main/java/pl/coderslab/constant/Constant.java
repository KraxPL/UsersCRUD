package pl.coderslab.constant;

public class Constant {
    public static final String ADD_USER = "INSERT INTO Workshop3.Users (email, username, password) VALUES (?, ?, ?)";
    public static final String UPDATE_USER = "UPDATE Workshop3.Users SET email = ?, username = ?, password = ? WHERE id = ?";
    public static final String SELECT_BY_ID = "SELECT email, username, password FROM Workshop3.Users WHERE id = ?";
    public static final String DELETE_USER = "DELETE FROM Workshop3.Users WHERE id = ?";
    public static final String SELECT_ALL_USERS = "SELECT * FROM Workshop3.Users";
    public static final String CREATE_DATABASE =
            "CREATE DATABASE IF NOT EXISTS Workshop3\n" +
                    "CHARACTER SET utf8mb4\n" +
                    "COLLATE utf8mb4_unicode_ci\n";
    public static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS Workshop3.Users\n" +
                    "(\n" +
                    "    id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,\n" +
                    "    email VARCHAR(255) UNIQUE,\n" +
                    "    username VARCHAR(255) NOT NULL ,\n" +
                    "    password VARCHAR(255) NOT NULL\n" +
                    ")";
    public static final String DbURL = "jdbc:mysql://localhost:3306?useSSL=false&characterEncoding=utf8&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String DbUser = "root";
    public static final String DbPass = "coderslab";
}
