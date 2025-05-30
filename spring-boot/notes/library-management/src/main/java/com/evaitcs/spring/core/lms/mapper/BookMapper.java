package com.evaitcs.spring.core.lms.mapper;

import com.evaitcs.spring.core.lms.dto.BookDetails;
import com.evaitcs.spring.core.lms.dto.CreateBookRequest;
import com.evaitcs.spring.core.lms.model.Book;

import java.util.List;

public class BookMapper {

  public static List<BookDetails> mapToDetailsList(List<Book> books) {
    return books.stream()
      .map(BookMapper::mapToDetails)
      .toList();
  }

  public static BookDetails mapToDetails(Book book) {
    return new BookDetails(book.getTitle(), book.getAuthor().getFullName());
  }

  public static Book mapToBook(CreateBookRequest createBookRequest) {
    Book book = new Book();
    book.setTitle(createBookRequest.title());
    return book;
  }
}
