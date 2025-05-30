package com.evaitcs.spring.core.lms.dto;

import java.util.List;

public record AuthorDetails(
  String name,
  List<BookDetails> books
  ) {
}
