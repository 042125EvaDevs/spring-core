package com.evaitcs.spring.core.di.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class DatabaseConfiguration {

  @Value("${db.url}")
  private String databaseUrl;

  @Value("${db.username}")
  private String username;

  @Value("${db.password}")
  private String password;

  @Bean
  public DataSource defaultDataSource() {

    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(databaseUrl);
    config.setUsername(username);
    config.setPassword(password);
    config.setDriverClassName("com.mysql.cj.jdbc.Driver");
    return new HikariDataSource(config);

  }
}
