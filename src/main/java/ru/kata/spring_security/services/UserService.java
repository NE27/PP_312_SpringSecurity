package ru.kata.spring_security.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring_security.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    void addUser(User user);

    List<User> getAllUsers();

    User findUserById(long id);

    User findUserByEmail(String email);

    void updateUser(User user);

    void deleteAllUsers();

    void deleteUserById(long id);

}
