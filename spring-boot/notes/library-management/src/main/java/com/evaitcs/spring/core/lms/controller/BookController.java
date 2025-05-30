package com.evaitcs.spring.core.lms.controller;

import com.evaitcs.spring.core.lms.dto.BookDetails;
import com.evaitcs.spring.core.lms.dto.CreateBookRequest;
import com.evaitcs.spring.core.lms.dto.UpdateBookRequest;
import com.evaitcs.spring.core.lms.service.BookService;
import org.springframework.http.HttpStatus;
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
  public ResponseEntity<List<BookDetails>> getAllBooks() {
    List<BookDetails> books = bookService.getAllBooks();

    return ResponseEntity.status(HttpStatus.OK)
      .body(books);
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookDetails> getBook(@PathVariable Long id) {
    BookDetails book = bookService.getBook(id);

    return ResponseEntity.ok(book);
  }

  @PostMapping("")
  public ResponseEntity<BookDetails> createBook(
    @RequestBody
    CreateBookRequest createBookRequest
  ) {
    BookDetails book = bookService.createBook(createBookRequest);

    return ResponseEntity.status(HttpStatus.CREATED).body(book);
  }

  @PutMapping("/{id}")
  public ResponseEntity<BookDetails> updateBook(
    @RequestBody
    UpdateBookRequest updateBookRequest,
    @PathVariable("id")
    Long bookId
  ) {
      BookDetails updatedBook = bookService.updateBook(bookId, updateBookRequest);
      return ResponseEntity.ok(updatedBook);
  }

  @DeleteMapping("/{id}")
  public String deleteBook(@PathVariable Long id) {
    BookDetails removeBook = bookService.deleteBook(id);
    return "Removed book " + removeBook.title();
  }

}
