package com.crud.kodillalibrary.service;

import com.crud.kodillalibrary.domain.User;
import com.crud.kodillalibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUser(final Long id){
        return userRepository.findById(id);
    }

    public User saveUser(final User book){
        return userRepository.save(book);
    }

    public void deleteUser(final Long id){
        userRepository.deleteById(id);
    }
}

