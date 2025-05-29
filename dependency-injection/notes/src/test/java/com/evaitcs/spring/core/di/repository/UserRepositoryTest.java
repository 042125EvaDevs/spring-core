package com.evaitcs.spring.core.di.repository;

import com.evaitcs.spring.core.di.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserRepositoryTest {



  private UserRepository repository;

  @BeforeEach
  void setUp() {

//    repository = new UserRepositoryImpl();
  }

  @AfterEach
  void tearDown() {
    repository = null;
  }


    @Test
    @DisplayName("should save User")
    void saveUserSetId() {
        /* GIVEN - user */
        User user = User.builder()
          .email("devin@catuns.xyz")
            .name("Devin")
              .build();

        /* WHEN - save */
        User saved = repository.save(user);

        /* THEN - set id */
        Assertions.assertThat(user.getId()).isNotZero();
    }

    @Test
    @DisplayName("should not take duplicate emails")
    void saveTwiceDuplicateEmailThrowsException() {
        /* GIVEN - duplicate email */
      User user = User.builder()
        .email("devin@catuns.xyz")
        .name("Devin")
        .build();

        /* WHEN - save twice */
        repository.save(user);

        /* THEN - throws exception */
        Assertions.assertThatThrownBy(() -> repository.save(user));
    }

    @Test
    @DisplayName("should generate unique ids")
    void saveUniqueUsersCreatesUniqueId() {
        /* GIVEN - unique users */
      User user = User.builder()
        .email("devin@catuns.xyz")
        .name("Devin")
        .build();
      User user2 = User.builder()
        .email("devin2@catuns.xyz")
        .name("Devin")
        .build();

        /* WHEN - save */
        user = repository.save(user);
        user2 = repository.save(user2);

        /* THEN - creates unique id */
        Assertions.assertThat(user.getId())
          .isNotEqualTo(user2.getId());
    }
}
