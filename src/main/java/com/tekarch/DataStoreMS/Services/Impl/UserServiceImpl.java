package com.tekarch.DataStoreMS.Services.Impl;

import com.tekarch.DataStoreMS.Models.User;
import com.tekarch.DataStoreMS.Repositories.UserRepository;
import com.tekarch.DataStoreMS.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    // Get a user by ID
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);  // Return null if not found
    }

    @Override
    // Update a user by ID
    public User updateUser(Long userId, User updatedUser) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPhone(updatedUser.getPhone());
            return userRepository.save(existingUser);
        }
        return null;  // Return null if user does not exist
    }

    @Override
    // Delete a user by ID
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
