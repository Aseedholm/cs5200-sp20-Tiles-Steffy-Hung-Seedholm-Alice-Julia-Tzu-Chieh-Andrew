package edu.northeastern.cs5200.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.daos.LibraryDao;
import edu.northeastern.cs5200.models.LibraryCard;

@RestController
@CrossOrigin(origins = "*")
public class LibraryCardController {

	@Autowired
	LibraryDao libraryDao;

	@PostMapping("api/libraryCard")
	public LibraryCard createLibraryCard(@RequestBody LibraryCard card) {
		return libraryDao.createLibraryCard(card);
	}

	@GetMapping("/api/libraryCards")
	public List<LibraryCard> findAllLibraryCards() {
		return (List<LibraryCard>) libraryDao.findAllLibraryCards();
	}

	@GetMapping("/api/libraryCard/memberId/{memberId}")
	public LibraryCard getByMemberId(@PathVariable("memberId") int memberId) {
		return libraryDao.findLibraryCardByMemberId(memberId);
	}

	@GetMapping("/api/libraryCard/memberUsername/{memberUsername}")
	public LibraryCard getByMemberUsername(@PathVariable("memberUsername") String memberUsername) {
		return libraryDao.findLibraryCardByMemberUsername(memberUsername);
	}
}
