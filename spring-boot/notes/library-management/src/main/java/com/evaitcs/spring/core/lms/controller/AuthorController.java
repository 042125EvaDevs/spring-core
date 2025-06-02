package com.evaitcs.spring.core.lms.controller;

import com.evaitcs.spring.core.lms.dto.AuthorDetails;
import com.evaitcs.spring.core.lms.dto.CreateAuthorRequest;
import com.evaitcs.spring.core.lms.dto.UpdateAuthorRequest;
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
  public ResponseEntity<List<AuthorDetails>> getAllAuthors(){
    List<AuthorDetails> authors = authorService.getAllAuthors();
    return ResponseEntity.status(HttpStatus.OK).body(authors);
  }

  @GetMapping ("/{id}")
  public ResponseEntity<AuthorDetails> getAuthor(@PathVariable Long id){

    AuthorDetails author = authorService.getAuthor(id);
    return ResponseEntity.ok(author);
  }



  @PostMapping("")
  public ResponseEntity<AuthorDetails> createAuthor(
    @RequestBody
    CreateAuthorRequest createAuthorRequest
  ){
    AuthorDetails author = authorService.createAuthor(createAuthorRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(author);

  }

  @DeleteMapping("")
  public String deleteAuthor(@PathVariable Long id){
    AuthorDetails removeAuthor = authorService.deleteAuthor(id);
    return "Removed Author " + removeAuthor.name();
  }

  @PutMapping("/{id}")
  public ResponseEntity<AuthorDetails> updateAuthor(
    @RequestBody
    UpdateAuthorRequest updateAuthorRequest,
    @PathVariable("id")
    Long authorId
  ) {
    AuthorDetails updatedAuthor = authorService.updateAuthor(authorId, updateAuthorRequest);
    return ResponseEntity.ok(updatedAuthor);
  }
}




