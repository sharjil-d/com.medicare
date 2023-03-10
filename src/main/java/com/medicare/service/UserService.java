package com.medicare.service;

import com.medicare.entity.User;
import com.medicare.entity.UserRole;

import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRoleSet) throws Exception;
    public User getUser(String username);
    public void deleteUser(long userid);
}
