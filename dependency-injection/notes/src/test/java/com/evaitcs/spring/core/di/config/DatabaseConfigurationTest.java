package com.evaitcs.spring.core.di.config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConfigurationTest {

  private DatabaseConfiguration configuration;

  @BeforeEach
  void setUp() {
    configuration = new DatabaseConfiguration();
  }

  @AfterEach
  void tearDown() {
    configuration = null;
  }

}
