package com.winterflame.aura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winterflame.aura.entity.User;
import com.winterflame.aura.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public int addUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public int modifyUser(User user) {
        return userRepository.update(user);
    }

    @Transactional
    public void deleteUser(int userId) {
        userRepository.delete(userId);
    }

    public User getUser(int userId) {
        return userRepository.getById(userId);
    }

    public List<User> getUsers() {
        return userRepository.getAll();
    }
}
