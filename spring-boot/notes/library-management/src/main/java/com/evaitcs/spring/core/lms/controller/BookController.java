package com.evaitcs.spring.core.lms.controller;

import com.evaitcs.spring.core.lms.dto.CreateBookRequest;
import com.evaitcs.spring.core.lms.dto.UpdateBookRequest;
import com.evaitcs.spring.core.lms.model.Book;
import com.evaitcs.spring.core.lms.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

  private final BookService bookService;


  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("")
  public ResponseEntity<List<Book>> getAllBooks() {
    List<Book> books = bookService.getAllBooks();

    return ResponseEntity.status(HttpStatus.OK)
      .body(books);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Book> getBook(@PathVariable Long id) {
    Book book = bookService.getBook(id);

    return ResponseEntity.ok(book);
  }

  @PostMapping("")
  public ResponseEntity<Book> createBook(
    @RequestBody
    CreateBookRequest createBookRequest
  ) {
    Book book = bookService.createBook(createBookRequest);

    return ResponseEntity.status(HttpStatus.CREATED).body(book);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Book> updateBook(
    @RequestBody
    UpdateBookRequest updateBookRequest,
    @PathVariable("id")
    Long bookId
  ) {
      Book updatedBook = bookService.updateBook(bookId, updateBookRequest);
      return ResponseEntity.ok(updatedBook);
  }

  @DeleteMapping("/{id}")
  public String deleteBook(@PathVariable Long id) {
    Book removeBook = bookService.deleteBook(id);
    return "Removed book " + removeBook.getTitle();
  }

}
