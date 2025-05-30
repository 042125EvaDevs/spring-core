package com.evaitcs.spring.core.lms.service;

import com.evaitcs.spring.core.lms.dto.CreateAuthorRequest;
import com.evaitcs.spring.core.lms.model.Author;
import com.evaitcs.spring.core.lms.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

  private final AuthorRepository repository;

  public AuthorServiceImpl(AuthorRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Author> getAllAuthors() {
    return List.of();
  }

  @Override
  public Author deleteAuthor(Long id) {
    return null;
  }

  @Override
  public Author getAuthor(Long id) {
    return null;
  }

  @Override
  public Author createAuthor(CreateAuthorRequest createAuthorRequest) {
    return null;
  }
}
