package com.evaitcs.spring.core.lms.service;

import com.evaitcs.spring.core.lms.dto.AuthorDetails;
import com.evaitcs.spring.core.lms.dto.CreateAuthorRequest;
import com.evaitcs.spring.core.lms.dto.UpdateAuthorRequest;

import java.util.List;

public interface AuthorService {

  List<AuthorDetails> getAllAuthors();

  AuthorDetails deleteAuthor(Long id);

  AuthorDetails getAuthor(Long id);

  AuthorDetails createAuthor(CreateAuthorRequest createAuthorRequest);

  AuthorDetails updateAuthor(Long authorId, UpdateAuthorRequest updateAuthorRequest);
}
