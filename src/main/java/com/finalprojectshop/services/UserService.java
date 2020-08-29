package com.finalprojectshop.services;

import com.finalprojectshop.model.User;
import com.finalprojectshop.security.PasswordResetToken;
import com.finalprojectshop.security.UserRole;

import java.util.Set;

public interface UserService {
    PasswordResetToken getPasswordResetToken(final String token);

    void createPasswordResetTokenForUser(final User user, final String token);

    User findByUsername(String username);

    User findByEmail(String email);

    User createUser(User user, Set<UserRole> userRoles) throws Exception;


}
