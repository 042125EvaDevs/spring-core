package com.evaitcs.spring.core.lms.service;

import com.evaitcs.spring.core.lms.dto.CreateAuthorRequest;
import com.evaitcs.spring.core.lms.model.Author;

import java.util.List;

public interface AuthorService {

  List<Author> getAllAuthors();

  Author deleteAuthor(Long id);

  Author getAuthor(Long id);

  Author createAuthor(CreateAuthorRequest createAuthorRequest);

}
