package com.secure.notes.services;

import com.secure.notes.dtos.UserDTO;
import com.secure.notes.entity.User;
import com.secure.notes.entity.Role;
import java.util.List;

public interface UserService {
    void updateUserRole(Long userId, String roleName);

    List<User> getAllUsers();

    UserDTO getUserById(Long id);

    User findByUsername(String username);

    void updateAccountLockStatus(Long userId, boolean lock);

    List<Role> getAllRoles();

    void updateAccountExpiryStatus(Long userId, boolean expire);

    void updateAccountEnabledStatus(Long userId, boolean enabled);

    void updateCredentialsExpiryStatus(Long userId, boolean expire);
    void updatePassword(Long userId, String password);

    void generatePasswordResetToken(String email);

    void resetPassword(String token, String newPassword);
}
