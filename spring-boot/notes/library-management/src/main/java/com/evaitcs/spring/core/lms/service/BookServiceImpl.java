package com.evaitcs.spring.core.lms.service;

import com.evaitcs.spring.core.lms.dto.BookDetails;
import com.evaitcs.spring.core.lms.dto.CreateBookRequest;
import com.evaitcs.spring.core.lms.dto.UpdateBookRequest;
import com.evaitcs.spring.core.lms.mapper.BookMapper;
import com.evaitcs.spring.core.lms.model.Author;
import com.evaitcs.spring.core.lms.model.Book;
import com.evaitcs.spring.core.lms.repository.AuthorRepository;
import com.evaitcs.spring.core.lms.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

  private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

  private final BookRepository repository;
  private final AuthorRepository authorRepository;


  public BookServiceImpl(BookRepository repository, AuthorRepository authorRepository) {
    this.repository = repository;
    this.authorRepository = authorRepository;
  }

  @Override
  public List<BookDetails> getAllBooks() {
    List<Book> all = repository.findAll();
    return BookMapper.mapToDetailsList(all);
  }

  @Override
  public BookDetails createBook(CreateBookRequest createBookRequest) {

    Author author = getAuthorById(createBookRequest.authorId());

    Book book = BookMapper.mapToBook(createBookRequest);
    book.setAuthor(author);

    book = repository.save(book);
    return book;
  }

  private Author getAuthorById(Long id) {
    return authorRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("No author with given id " + id));
  }

  @Override
  public BookDetails getBook(Long id) {
    Optional<Book> bookOptional = repository.findById(id);

    if (bookOptional.isEmpty()) {
      throw new RuntimeException("Book not found with id " + id);
    }

    Book book = bookOptional.get();

    return BookMapper.mapToDetails(book);
  }

  @Override
  public BookDetails updateBook(Long bookId, UpdateBookRequest updateBookRequest) {
    Book book = findById(bookId);

    if (updateBookRequest.authorId() != null) {
      try {
        Author author = getAuthorById(updateBookRequest.authorId());
        book.setAuthor(author);
      } catch (EntityNotFoundException e) {
        log.info(e.getMessage());
      }
    }

    if (updateBookRequest.title() != null) {
      book.setTitle(updateBookRequest.title());
    }

    repository.save(book);
    return BookMapper.mapToDetails(book);
  }

  private Book findById(Long bookId) {
    Book book = repository.findById(bookId)
      .orElseThrow(() -> new EntityNotFoundException("Book not found with id " + bookId));
    return book;
  }

  @Override
  public BookDetails deleteBook(Long id) {
    Book book = findById(id);
    repository.delete(book);
    return BookMapper.mapToDetails(book);
  }


}
