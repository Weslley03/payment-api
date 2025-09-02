package com.weftecnologia.payment_api.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConnection {

  private static final String URL = EnvVariables.getUrlDatabase();
  private static final String USER = EnvVariables.getUserDatabase();
  private static final String PASSWORD = EnvVariables.getUserPasswordDatabase();

  @Bean
  public DataSource dataSource() {
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setJdbcUrl(URL);
    dataSource.setUsername(USER);
    dataSource.setPassword(PASSWORD);
    dataSource.setDriverClassName("org.postgresql.Driver");
    return dataSource;
  }
}
