package com.users.spring.jpa.h2.service;

import com.users.spring.jpa.h2.model.Users;
import com.users.spring.jpa.h2.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Users> findAll() {
        return userRepository.findAll();
    }

    public Users save(Users users) {
        return userRepository.save(users);
    }

    public Optional<Users> findById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
