package edu.northeastern.cs5200.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.models.Admin;
import edu.northeastern.cs5200.repositories.AdminRepository;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {
  @Autowired
  AdminRepository adminRepository;

  @PostMapping("api/admins")
  public Admin createAdmin(@RequestBody Admin admin) {
    return adminRepository.save(admin);
  }
}
