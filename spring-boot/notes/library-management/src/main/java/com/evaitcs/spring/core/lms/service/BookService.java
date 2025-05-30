package com.evaitcs.spring.core.lms.service;

import com.evaitcs.spring.core.lms.dto.CreateBookRequest;
import com.evaitcs.spring.core.lms.dto.UpdateBookRequest;
import com.evaitcs.spring.core.lms.model.Book;

import java.util.List;

public interface BookService {
  List<Book> getAllBooks();

  Book createBook(CreateBookRequest createBookRequest);

  Book getBook(Long id);

  Book updateBook(Long bookId, UpdateBookRequest updateBookRequest);

  Book deleteBook(Long id);
}
