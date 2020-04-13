package edu.northeastern.cs5200.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.models.Librarian;
import edu.northeastern.cs5200.repositories.LibrarianRepository;

@RestController
@CrossOrigin(origins = "*")
public class LibrarianController {
  @Autowired
  LibrarianRepository librarianRepository;

  @PostMapping("api/librarians")
  public Librarian createLibrarian(@RequestBody Librarian librarian) {
    return librarianRepository.save(librarian);
  }
}
