package ru.kata.spring_security.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring_security.models.Role;
import ru.kata.spring_security.repositories.RoleRepository;
import ru.kata.spring_security.services.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role findByRole(String role) {
        return roleRepository.findByRole(role).orElse(null);
    }

    @Override
    public List<Role> listRoles() {
        return roleRepository.findAll();
    }
}
