package com.evaitcs.spring.core.lms.service;

import com.evaitcs.spring.core.lms.dto.BookDetails;
import com.evaitcs.spring.core.lms.dto.CreateBookRequest;
import com.evaitcs.spring.core.lms.dto.UpdateBookRequest;

import java.util.List;

public interface BookService {
  List<BookDetails> getAllBooks();

  BookDetails createBook(CreateBookRequest createBookRequest);

  BookDetails getBook(Long id);

  BookDetails updateBook(Long bookId, UpdateBookRequest updateBookRequest);

  BookDetails deleteBook(Long id);
}
