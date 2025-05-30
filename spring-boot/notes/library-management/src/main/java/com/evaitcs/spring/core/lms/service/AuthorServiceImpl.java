package com.evaitcs.spring.core.lms.service;

import com.evaitcs.spring.core.lms.dto.AuthorDetails;
import com.evaitcs.spring.core.lms.dto.CreateAuthorRequest;
import com.evaitcs.spring.core.lms.dto.UpdateAuthorRequest;
import com.evaitcs.spring.core.lms.mapper.AuthorMapper;
import com.evaitcs.spring.core.lms.model.Author;
import com.evaitcs.spring.core.lms.repository.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

  private static final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);

  private final AuthorRepository repository;
  private final AuthorRepository authorRepository;


  public AuthorServiceImpl(AuthorRepository repository, AuthorRepository authorRepository) {
    this.repository = repository;
    this.authorRepository = authorRepository;
  }

  @Override
  public List<AuthorDetails> getAllAuthors() {
    List<Author> all = repository.findAll();

    List<AuthorDetails> detailsList = AuthorMapper.mapToDetailsList(all);
    return detailsList;
  }

  @Override
  public AuthorDetails createAuthor(CreateAuthorRequest createAuthorRequest) {
    Author author = AuthorMapper.mapToAuthor(createAuthorRequest);
    author = repository.save(author);
    return AuthorMapper.mapToDetails(author);
  }

  private Author getAuthorById(Long id) {
    return authorRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("No author with given id " + id));
  }

  @Override
  public AuthorDetails getAuthor(Long id) {
    Author author = findById(id);
    return AuthorMapper.mapToDetails(author);
  }

  @Override
  public AuthorDetails updateAuthor(Long authorId, UpdateAuthorRequest updateAuthorRequest) {
    Author author = findById(authorId);

    AuthorMapper.update(author, updateAuthorRequest);

    repository.save(author);
    return AuthorMapper.mapToDetails(author);
  }

  private Author findById(Long authorId) {
    Author author = repository.findById(authorId)
      .orElseThrow(() -> new EntityNotFoundException("Author not found with id " + authorId));
    return author;
  }

  @Override
  public AuthorDetails deleteAuthor(Long id) {
    Author author = findById(id);
    repository.delete(author);
    return AuthorMapper.mapToDetails(author);
  }

}
