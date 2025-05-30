package com.evaitcs.spring.core.lms.mapper;

import com.evaitcs.spring.core.lms.dto.AuthorDetails;
import com.evaitcs.spring.core.lms.dto.CreateAuthorRequest;
import com.evaitcs.spring.core.lms.dto.UpdateAuthorRequest;
import com.evaitcs.spring.core.lms.model.Author;

import java.util.List;

public class AuthorMapper {


  public static List<AuthorDetails> mapToDetailsList(List<Author> all) {
    return all.stream()
      .map(AuthorMapper::mapToDetails)
      .toList();
  }

  public static AuthorDetails mapToDetails(Author author) {
    return new AuthorDetails(
      author.getFullName(),
      BookMapper.mapToDetailsList(author.getBooks())
    );
  }

  public static Author mapToAuthor(CreateAuthorRequest createAuthorRequest) {
    Author author = new Author();
    author.setFirstName(createAuthorRequest.firstName());
    author.setLastName(createAuthorRequest.lastName());
    return author;
  }

  public static void update(Author author, UpdateAuthorRequest updateAuthorRequest) {
    if (updateAuthorRequest.firstName() != null) {
      author.setFirstName(updateAuthorRequest.firstName());
    }

    if (updateAuthorRequest.lastName() != null) {
      author.setLastName(updateAuthorRequest.lastName());
    }
  }
}
