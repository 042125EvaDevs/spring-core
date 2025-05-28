package com.evaitcs.spring.core.di.service;

import com.evaitcs.spring.core.di.model.User;

import java.util.List;

public interface UserService {

  User createUser();

  User getCurrentUser();

  List<User> getAllUsers();

  User loginUser(String email);
}
