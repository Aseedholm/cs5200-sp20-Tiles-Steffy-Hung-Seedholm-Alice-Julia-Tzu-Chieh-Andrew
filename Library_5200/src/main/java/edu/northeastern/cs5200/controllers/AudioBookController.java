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
import edu.northeastern.cs5200.models.AudioBook;
import edu.northeastern.cs5200.models.LibraryCard;

@RestController
@CrossOrigin(origins = "*")
public class AudioBookController {

	@Autowired
	LibraryDao libraryDao;

	@PostMapping("api/audioBook")
	public AudioBook createAudioBook(@RequestBody AudioBook book) {
		return libraryDao.createAudioBook(book);
	}

	@GetMapping("/api/audioBooks")
	public List<AudioBook> findAllAudioBooks() {
		return (List<AudioBook>) libraryDao.findAllAudioBooks();
	}
}
