package com.evaitcs.spring.core.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;


@Profile("prod")
@Repository
public class ProductionInventoryRepository implements InventoryRepository {

  {
    System.out.println("This is the PRODUCTION repository");
  }
}
