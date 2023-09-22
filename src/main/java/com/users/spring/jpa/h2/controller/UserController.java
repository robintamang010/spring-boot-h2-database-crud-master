package com.users.spring.jpa.h2.controller;


import com.users.spring.jpa.h2.model.Users;
import com.users.spring.jpa.h2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Users> getAllUsers() {
         if(userService.findAll().isEmpty()){
             userService.save(new Users("Test1", "Test2", "Mr", "test1@gmail.com"));
         };
        return userService.findAll();
    }

    @PostMapping
    public Users createUser(@RequestBody Users users) {
        return userService.save(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users updatedUsers) {
        Optional<Users> userOptional = userService.findById(id);

        if (userOptional.isPresent()) {
            Users existingUsers = userOptional.get();
            existingUsers.setFirstName(updatedUsers.getFirstName());
            existingUsers.setLastName(updatedUsers.getLastName());
            existingUsers.setEmail(updatedUsers.getEmail());
            userService.save(existingUsers);
            return ResponseEntity.ok(existingUsers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<Users> userOptional = userService.findById(id);

        if (userOptional.isPresent()) {
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
