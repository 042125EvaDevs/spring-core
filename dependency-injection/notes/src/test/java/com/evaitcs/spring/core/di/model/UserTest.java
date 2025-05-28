package com.evaitcs.spring.core.di.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class UserTest {

  private User user;

  @BeforeEach
  void setUp() {
    user = new User();
  }

  @AfterEach
  void tearDown() {
    user = null;
  }

  @Test
  @DisplayName("should set email")
  void setEmailShouldWork() {

      /* GIVEN - email */
      String email = "devin@catuns.xyz";

      /* WHEN - set */
      user.setEmail(email);

      /* THEN - should work */
      Assertions.assertThat(user.getEmail())
        .isEqualTo(email);
  }
}
