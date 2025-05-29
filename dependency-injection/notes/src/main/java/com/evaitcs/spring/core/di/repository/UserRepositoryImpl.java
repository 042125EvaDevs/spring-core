package com.evaitcs.spring.core.di.repository;

import com.evaitcs.spring.core.di.model.Address;
import com.evaitcs.spring.core.di.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserRepositoryImpl implements UserRepository {

  private final DataSource dataSource;

  public UserRepositoryImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public User save(User newUser) {
    try (Connection connection = dataSource.getConnection()) {

      /**
       * 1. Create sql statement
       * 2.
       */
      PreparedStatement addressStatement = createAddress(newUser.getAddress(), connection);
      PreparedStatement userStatement = createUser(newUser, connection);



    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return newUser;
  }

  private PreparedStatement createUser(User user, Connection connection) throws SQLException {
    String sql = "INSERT INTO user_entity (name, email, password, address_id) " +
      "VALUES (?,?,?, (SELECT LAST_INSERT_ID()))";
    PreparedStatement userStatement = connection.prepareStatement(sql);
    userStatement.setString(1, user.getName());
    userStatement.setString(2, user.getEmail());
    userStatement.setString(3, user.getPassword());
    userStatement.execute();

    return userStatement;
  }

  private PreparedStatement createAddress(Address address, Connection connection) throws SQLException {
    String addressQuery = "INSERT INTO address (building_number, street_name, city, state, zipCode, unit_number) " +
      "VALUES (?,?,?,?,?,?)";

    PreparedStatement addressStatement = connection.prepareStatement(addressQuery);

    addressStatement.setInt(1, address.getBuildingNumber());
    addressStatement.setString(2, address.getStreetName());
    addressStatement.setString(3, address.getCity());
    addressStatement.setString(4, address.getState());
    addressStatement.setInt(5, address.getZipCode());
    addressStatement.setString(6, address.getUnitNumber());
    addressStatement.execute();
    return addressStatement;
  }
}
