package com.evaitcs.spring.core.di.service;

import com.evaitcs.spring.core.di.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

  private long idSequence = 1;

  private long nextId() {
    return ++idSequence;
  }

  @Override
  public User createUser() {
    User user = new User();
    user.setName("guest");
    user.setId(nextId());
    return user;
  }

  @Override
  public User getCurrentUser() {
    return null;
  }

  @Override
  public List<User> getAllUsers() {
    return List.of();
  }

  @Override
  public User loginUser(String email) {
    return null;
  }
}
