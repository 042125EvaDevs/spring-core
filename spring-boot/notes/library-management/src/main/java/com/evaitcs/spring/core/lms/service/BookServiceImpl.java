package com.evaitcs.spring.core.lms.service;

import com.evaitcs.spring.core.lms.dto.CreateBookRequest;
import com.evaitcs.spring.core.lms.dto.UpdateBookRequest;
import com.evaitcs.spring.core.lms.model.Book;
import com.evaitcs.spring.core.lms.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

  private final BookRepository repository;


  public BookServiceImpl(BookRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Book> getAllBooks() {
    return repository.findAll();
  }

  @Override
  public Book createBook(CreateBookRequest createBookRequest) {
    Book book = new Book();
    book.setAuthor(createBookRequest.author());
    book.setTitle(createBookRequest.title());

    book = repository.save(book);
    return book;
  }

  @Override
  public Book getBook(Long id) {
    Optional<Book> bookOptional = repository.findById(id);

    if (bookOptional.isEmpty()) {
      throw new RuntimeException("Book not found with id " + id);
    }

    Book book = bookOptional.get();

    return book;
  }

  @Override
  public Book updateBook(Long bookId, UpdateBookRequest updateBookRequest) {
    Book book = findById(bookId);

    if (updateBookRequest.title() != null) {
      book.setTitle(updateBookRequest.title());
    }

    if (updateBookRequest.author() != null) {
      book.setTitle(updateBookRequest.author());
    }

    repository.save(book);
    return book;
  }

  private Book findById(Long bookId) {
    Book book = repository.findById(bookId)
      .orElseThrow(() -> new EntityNotFoundException("Book not found with id " + bookId));
    return book;
  }

  @Override
  public Book deleteBook(Long id) {
    Book book = findById(id);
    repository.delete(book);
    return book;
  }


}
