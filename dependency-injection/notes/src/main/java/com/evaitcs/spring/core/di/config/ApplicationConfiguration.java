package com.evaitcs.spring.core.di.config;

import com.evaitcs.spring.core.di.repository.UserRepository;
import com.evaitcs.spring.core.di.repository.UserRepositoryImpl;
import com.evaitcs.spring.core.di.service.UserService;
import com.evaitcs.spring.core.di.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

@ComponentScan(basePackages = {"com.evaitcs.spring.core"})
public class ApplicationConfiguration {

  @Bean
  UserService defaultUserService(UserRepository repository) {
    return new UserServiceImpl(repository);
  }

  @Bean
  UserRepository defaultUserRepository(DataSource dataSource) {
    return new UserRepositoryImpl(dataSource);
  }

}
