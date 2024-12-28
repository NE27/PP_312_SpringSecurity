package ru.kata.spring_security.initializers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring_security.models.Role;
import ru.kata.spring_security.models.User;
import ru.kata.spring_security.services.RoleService;
import ru.kata.spring_security.services.UserService;

import jakarta.annotation.PostConstruct;
import java.util.List;

@Component
public class DataInitializer {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public DataInitializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void init() {
        Role roleAdmin = roleService.findByRole("ROLE_ADMIN");
        if (roleAdmin == null) {
            roleAdmin = new Role("ROLE_ADMIN");
            roleService.addRole(roleAdmin);
        }
        Role roleUser = roleService.findByRole("ROLE_USER");
        if (roleUser == null) {
            roleUser = new Role("ROLE_USER");
            roleService.addRole(roleUser);
        }

        User admin = userService.findUserByEmail("admin@main.com");
        if (admin == null) {
            admin = new User("admin", "admin", "admin@main.com", List.of(roleAdmin, roleUser));
            userService.addUser(admin);
        }
        User user = userService.findUserByEmail("user@main.com");
        if (user == null) {
            user = new User("user", "user", "user@main.com", List.of(roleUser));
            userService.addUser(user);
        }

    }
}
