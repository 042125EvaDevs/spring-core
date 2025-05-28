package com.evaitcs.spring.core.di.config;

import com.evaitcs.spring.core.di.service.UserService;
import com.evaitcs.spring.core.di.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;

public class ApplicationConfiguration {

  @Bean
  UserService defaultUserService() {
    return new UserServiceImpl();
  }
}
