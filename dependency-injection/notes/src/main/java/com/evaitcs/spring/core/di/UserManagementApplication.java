package com.evaitcs.spring.core.di;

import com.evaitcs.spring.core.di.config.ApplicationConfiguration;
import com.evaitcs.spring.core.di.model.User;
import com.evaitcs.spring.core.di.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserManagementApplication {

  public static void main(String[] args) {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

    UserService userService = applicationContext.getBean(UserService.class);

    User user = userService.createUser();

    System.out.println(user);
  }
}
