package com.evaitcs.spring.core.lms.repository;

import com.evaitcs.spring.core.lms.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
