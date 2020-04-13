package edu.northeastern.cs5200.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.models.Member;
import edu.northeastern.cs5200.repositories.MemberRepository;

@RestController
@CrossOrigin(origins = "*")
public class MemberController {
  @Autowired
  MemberRepository memberRepository;

  @PostMapping("api/members")
  public Member createMember(@RequestBody Member member) {
    return memberRepository.save(member);
  }
}
