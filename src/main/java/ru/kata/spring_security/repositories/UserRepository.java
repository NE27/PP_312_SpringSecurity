package ru.kata.spring_security.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring_security.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByEmail(String email);

}
