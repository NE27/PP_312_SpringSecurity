package ru.kata.spring_security.services;

import ru.kata.spring_security.models.Role;

import java.util.List;

public interface RoleService {

    void addRole(Role role);

    Role findByRole(String role);

    List<Role> listRoles();
}
