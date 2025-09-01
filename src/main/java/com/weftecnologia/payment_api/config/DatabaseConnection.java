package com.weftecnologia.payment_api.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

  private static final String URL = EnvVariables.getUrlDatabase();
  private static final String USER = EnvVariables.getUserDatabase();
  private static final String PASSWORD = EnvVariables.getUserPasswordDatabase();

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASSWORD);
  }

  public static void main(String[] args) {
    try (Connection connection = getConnection()) {
      System.out.println("database connection successful.");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
