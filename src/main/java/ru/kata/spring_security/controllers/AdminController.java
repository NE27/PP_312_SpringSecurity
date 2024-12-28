package ru.kata.spring_security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring_security.models.User;
import ru.kata.spring_security.services.RoleService;
import ru.kata.spring_security.services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String showAllUsers(Model model, Principal principal) {
        model.addAttribute("logout", userService.loadUserByUsername(principal.getName()));
        model.addAttribute("users", userService.getAllUsers());
        return "admin/index";
    }

    @DeleteMapping
    public String deleteAllUsers() {
        userService.deleteAllUsers();
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user, Model model, Principal principal) {
        model.addAttribute("logout", userService.loadUserByUsername(principal.getName()));
        model.addAttribute("roles", roleService.listRoles());
        return "admin/new";
    }

    @PostMapping("")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id, Principal principal) {
        model.addAttribute("logout", userService.loadUserByUsername(principal.getName()));
        model.addAttribute("roles", roleService.listRoles());
        model.addAttribute("user", userService.findUserById(id));
        return "admin/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }
}
