package com.tugas6.deploy.controller;

import com.tugas6.deploy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    // Simple in-memory storage for students
    private static final List<User> studentList = new ArrayList<>();

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password, Model model) {
        // Updated logic: Username 'admin', Password '20230140016'
        if ("admin".equals(username) && "20230140016".equals(password)) {
            return "redirect:/home";
        }
        model.addAttribute("error", true);
        return "login";
    }

    @GetMapping("/home")
    public String showHomePage(Model model) {
        model.addAttribute("students", studentList);
        return "home";
    }

    @GetMapping("/form")
    public String showFormPage(Model model) {
        model.addAttribute("student", new User());
        return "form";
    }

    @PostMapping("/form")
    public String handleFormSubmit(@ModelAttribute User student) {
        studentList.add(student);
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String handleLogout() {
        // For simple demo, just redirect to login
        return "redirect:/login";
    }
}
