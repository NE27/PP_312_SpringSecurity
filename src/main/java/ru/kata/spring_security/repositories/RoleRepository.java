package ru.kata.spring_security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring_security.models.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRole(String role);
}
