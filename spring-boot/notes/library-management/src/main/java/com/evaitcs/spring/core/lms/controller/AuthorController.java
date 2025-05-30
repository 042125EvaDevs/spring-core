package com.evaitcs.spring.core.lms.controller;

import com.evaitcs.spring.core.lms.dto.CreateAuthorRequest;
import com.evaitcs.spring.core.lms.model.Author;
import com.evaitcs.spring.core.lms.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {


  private final AuthorService authorService;

  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @GetMapping("")
  @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
  public ResponseEntity<List<Author>> getAllAuthors(){
    List<Author> authors = authorService.getAllAuthors();
    return ResponseEntity.status(HttpStatus.OK).body(authors);
  }

  @GetMapping ("/{id}")
  public ResponseEntity<Author> getAuthor(@PathVariable Long id){

    Author author = authorService.getAuthor(id);
    return ResponseEntity.ok(author);
  }



  @PostMapping("")
  public ResponseEntity<Author> createAuthor(
    @RequestBody
    CreateAuthorRequest createAuthorRequest
  ){
    Author author = authorService.createAuthor(createAuthorRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(author);

  }

  @DeleteMapping("")
  public String deleteAuthor(@PathVariable Long id){
    Author removeAuthor = authorService.deleteAuthor(id);
    return "Removed Author " + removeAuthor.getFullName();
  }
}




