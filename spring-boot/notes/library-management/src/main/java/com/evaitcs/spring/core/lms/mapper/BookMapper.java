package com.evaitcs.spring.core.lms.mapper;

import com.evaitcs.spring.core.lms.dto.BookDetails;
import com.evaitcs.spring.core.lms.model.Book;

import java.util.List;

public class BookMapper {

  public static List<BookDetails> mapToDetailsList(List<Book> books) {
    return books.stream()
      .map(BookMapper::mapToDetails)
      .toList();
  }

  private static BookDetails mapToDetails(Book book) {
    return new BookDetails(book.getTitle(), book.getAuthor().getFullName());
  }

}
