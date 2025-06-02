package com.evaitcs.spring.core.lms.service;


import com.evaitcs.spring.core.lms.dto.BookDetails;
import com.evaitcs.spring.core.lms.dto.CreateBookRequest;
import com.evaitcs.spring.core.lms.model.Author;
import com.evaitcs.spring.core.lms.model.Book;
import com.evaitcs.spring.core.lms.repository.AuthorRepository;
import com.evaitcs.spring.core.lms.repository.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

  @InjectMocks
  private BookServiceImpl bookService;

  @Mock
  private AuthorRepository authorRepository;

  @Mock
  private BookRepository bookRepository;


  @Test
  void getAllBooks() {
    Author author = new Author(1L, "John", "Doe");
    Book book = new Book(1L,"Book 1", author);
    Book book2 = new Book(2L,"Book 2", author);

    author.getBooks().add(book);
    author.getBooks().add(book2);

    List<Book> all = List.of(book, book2);

    Mockito.when(bookRepository.findAll()).thenReturn(all);

    List<BookDetails> allBooks = bookService.getAllBooks();
    BookDetails first = allBooks.get(0);

    Assertions.assertThat(first.title()).isEqualTo("Book 1");
    Assertions.assertThat(first.authorName()).isEqualTo("John Doe");
  }

  @Test
  @DisplayName("should create book")
  void createBookCalledCreateBookRequestReturnsBookDetails() {
    /* GIVEN - create book request */
    final String title = "Book 1";
    final Long authorId = 1L;

    CreateBookRequest request = new CreateBookRequest(title, authorId);

    /* WHEN - create book called  */
    when(authorRepository.findById(authorId))
      .thenReturn(Optional.of(new Author(authorId, "John", "Doe")));
    when(bookRepository.save(any(Book.class)))
      .thenReturn(any(Book.class));

    BookDetails createdBook = bookService.createBook(request);

    /* THEN - returns book details */
      Assertions.assertThat(createdBook.title()).isEqualTo(title);
      Assertions.assertThat(createdBook.authorName()).isEqualTo("John Doe");
  }
}
