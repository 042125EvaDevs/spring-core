package com.evaitcs.spring.core.config;


import com.evaitcs.spring.core.model.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfiguration {

    public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
      Product product = (Product) context.getBean("product");

      System.out.println("product = " + product);

    }
}
