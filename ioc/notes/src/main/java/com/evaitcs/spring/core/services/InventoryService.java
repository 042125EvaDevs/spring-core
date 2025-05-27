package com.evaitcs.spring.core.services;

import com.evaitcs.spring.core.model.Product;
import com.evaitcs.spring.core.repository.InventoryRepository;

import java.util.List;

public class InventoryService {

  private final InventoryRepository inventoryRepository;

  public InventoryService(InventoryRepository inventoryRepository) {
    this.inventoryRepository = inventoryRepository;
  }

  public List<Product> getAllProducts() {
    return List.of(new Product("Macbook air"));
  }

}
