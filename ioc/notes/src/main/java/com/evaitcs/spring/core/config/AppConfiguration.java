package com.evaitcs.spring.core.config;

import com.evaitcs.spring.core.model.Product;
import com.evaitcs.spring.core.repository.DevInventoryRepository;
import com.evaitcs.spring.core.repository.InventoryRepository;
import com.evaitcs.spring.core.services.InventoryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@ComponentScan(basePackages = "com.evaitcs.spring.core.repository")
@Configuration
public class AppConfiguration {


  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

    InventoryService service = context.getBean(InventoryService.class);
    List<Product> allProducts = service.getAllProducts();

    System.out.println("allProducts = " + allProducts);
  }

  @Bean
  public InventoryService defaultInventoryService(InventoryRepository inventoryRepository) {
    return new InventoryService(inventoryRepository);
  }


}
