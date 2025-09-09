package com.weftecnologia.payment_api.config;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

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

  @Bean
  @DependsOn("dataSource")
  public Flyway flyway(DataSource dataSource) {
    Flyway flyway = Flyway.configure()
        .dataSource(dataSource)
        .locations("classpath:db/migration")
        .baselineOnMigrate(true)
        .load();

    flyway.migrate();
    return flyway;
  }
}
