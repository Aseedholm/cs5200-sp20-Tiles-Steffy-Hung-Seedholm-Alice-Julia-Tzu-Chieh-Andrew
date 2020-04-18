package edu.northeastern.cs5200;

import edu.northeastern.cs5200.daos.*;
import edu.northeastern.cs5200.models.*;
import org.apache.tomcat.jni.Library;
import org.junit.FixMethodOrder;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestSuite {

	@Autowired
	LibraryImpl libraryDao;

	static Member andrew, jason, julia, alice;
	static Book sapiens;

//	@Test
//	@Order(1)
//	public void aTest() {
//        libraryDao.truncateDatabase();
//
//        andrew = new Member();
//        andrew.setFirstName("Andrew");
//        andrew.setLastName("Seedholm");
//        andrew.setUsername("aseedholm");
//        andrew.setPassword("1234");
//        andrew.setEmail("a.s@northeastern.edu");
//
//        libraryDao.createMember(andrew);
//
//        List<Member> allMembers = libraryDao.findAllMembers();
//        assertEquals(1, allMembers.size());
//
//        sapiens = new Book();
//        sapiens.setGenre(Genre.HISTORY);
//        sapiens.setTitle("Sapiens");
//        sapiens.addCopy();
//
//        libraryDao.createBook(sapiens);
//        List<Book> allBooks = libraryDao.findAllBooks();
//        assertEquals(1, allBooks.size());
//
//	}

//	@Test
//	@Order(2)
//    public void bTest() {
//		Librarian librarian = new Librarian();
//		librarian.setFirstName("C");
//		librarian.setLastName("C");
//		librarian.setUsername("CCC");
//		librarian.setPassword("14124");
//		librarian.setEmail("C@northeastern.edu");
//		libraryDao.createLibrarian(librarian);
//		LibraryCard card = libraryDao.findLibraryCardByMemberUsername("DDD");
//		System.out.println("CardID = " + card.getId());
//    }

	@Test
	@Order(2)
	public void testIsUnderThirteen() {

		Member youngKid = new Member();
		java.util.Date utilDate = new java.util.Date();
		Date today = new java.sql.Date(utilDate.getTime());
		youngKid.setDateOfBirth(today);
		assertTrue(youngKid.isUnderThirteen());

		Member olderKid = new Member();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		c.add(Calendar.YEAR, -20);
		java.sql.Date oldPersonDOB = new Date(c.getTimeInMillis());
		olderKid.setDateOfBirth(oldPersonDOB);
		assertFalse(olderKid.isUnderThirteen());

		// TODO make it work/test with almost exactly  13 years old




	}


}
