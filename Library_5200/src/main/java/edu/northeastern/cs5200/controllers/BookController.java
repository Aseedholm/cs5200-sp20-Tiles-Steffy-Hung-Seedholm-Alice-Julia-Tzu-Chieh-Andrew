package edu.northeastern.cs5200.controllers;

import edu.northeastern.cs5200.models.Admin;
import edu.northeastern.cs5200.models.Author;
import edu.northeastern.cs5200.models.Book;
import edu.northeastern.cs5200.models.Librarian;
import edu.northeastern.cs5200.models.Member;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.repositories.AdminRepository;
import edu.northeastern.cs5200.repositories.AuthorRepository;
import edu.northeastern.cs5200.repositories.BookRepository;
import edu.northeastern.cs5200.repositories.LibrarianRepository;
import edu.northeastern.cs5200.repositories.MemberRepository;
import edu.northeastern.cs5200.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    BookRepository bookRepository;








    @GetMapping("/books")
    public List<Book> findAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }







}
