package com.evaitcs.spring.core.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("!prod")
@Repository
public class DevInventoryRepository implements InventoryRepository {

  {
    System.out.println("This is the non production repository");
  }
}
