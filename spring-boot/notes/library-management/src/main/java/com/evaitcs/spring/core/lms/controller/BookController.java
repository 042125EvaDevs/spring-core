package com.evaitcs.spring.core.lms.controller;

import com.evaitcs.spring.core.lms.dto.CreateBookRequest;
import com.evaitcs.spring.core.lms.dto.UpdateBookRequest;
import com.evaitcs.spring.core.lms.model.Book;
import com.evaitcs.spring.core.lms.service.BookService;
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
  public List<Book> getAllBooks() {
    List<Book> books = bookService.getAllBooks();

    return books;
  }

  @GetMapping("/{id}")
  public Book getBook(@PathVariable Long id) {
    Book book = bookService.getBook(id);

    return book;
  }

  @PostMapping("")
  public Book createBook(
    @RequestBody
    CreateBookRequest createBookRequest
  ) {
    Book book = bookService.createBook(createBookRequest);

    return book;
  }

  @PutMapping("/{id}")
  public Book updateBook(
    @RequestBody
    UpdateBookRequest updateBookRequest,
    @PathVariable("id")
    Long bookId
  ) {
      Book updatedBook = bookService.updateBook(bookId, updateBookRequest);
      return updatedBook;
  }

  @DeleteMapping("/{id}")
  public String deleteBook(@PathVariable Long id) {
    Book removeBook = bookService.deleteBook(id);
    return "Removed book " + removeBook.getTitle();
  }

}
