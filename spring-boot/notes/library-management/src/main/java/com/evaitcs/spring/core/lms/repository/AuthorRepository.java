package com.evaitcs.spring.core.lms.repository;

import com.evaitcs.spring.core.lms.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
