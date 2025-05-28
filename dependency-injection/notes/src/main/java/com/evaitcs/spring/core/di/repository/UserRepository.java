package com.evaitcs.spring.core.di.repository;

import com.evaitcs.spring.core.di.model.User;

public interface UserRepository {

  User save(User newUser);
}
