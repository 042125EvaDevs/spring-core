package com.evaitcs.spring.core.di.service;

import com.evaitcs.spring.core.di.model.User;
import com.evaitcs.spring.core.di.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User createUser(String name, String email) {
    User newUser = new User();
    newUser.setName(name);
    newUser.setEmail(email);

    newUser = userRepository.save(newUser);

    return newUser;
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
