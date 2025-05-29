package com.evaitcs.spring.core.di.service;

import com.evaitcs.spring.core.di.model.User;

import java.util.List;

public interface UserService {

  User createUser(String name, String email);

  User getCurrentUser();

  List<User> getAllUsers();

  User loginUser(String email);
}
