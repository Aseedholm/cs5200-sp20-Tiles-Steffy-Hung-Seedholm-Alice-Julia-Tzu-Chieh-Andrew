package edu.northeastern.cs5200.controllers;

import edu.northeastern.cs5200.daos.LibraryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.northeastern.cs5200.models.Member;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MemberController {

  @Autowired
  LibraryDao libraryDao;

  @PostMapping("api/members")
  public Member createMember(@RequestBody Member member) {
    return libraryDao.createMember(member);
  }

  @GetMapping("/api/members")
  public List<Member> findAllMembers() {
    return libraryDao.findAllMembers();
  }

  @GetMapping("/api/members/id/{id}")
  public Member getById(@PathVariable("id") int id) {
    return libraryDao.findMemberById(id);
  }

  @GetMapping("/api/members/username/{username}")
  public Member getByUsername(@PathVariable("username") String username) {
    return libraryDao.findMemberByUsername(username);
  }


}
