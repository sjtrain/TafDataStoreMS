package com.tekarch.DataStoreMS.Services;

import com.tekarch.DataStoreMS.Models.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Long userId);
    User updateUser(Long userId, User updatedUser);
    void deleteUser(Long userId);

}
