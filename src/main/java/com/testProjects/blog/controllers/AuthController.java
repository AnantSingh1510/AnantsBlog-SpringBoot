package com.testProjects.blog.controllers;

import com.testProjects.blog.models.User;
import com.testProjects.blog.repositories.UserRepository;
import com.testProjects.blog.services.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public String signup(@ModelAttribute("user")User user, @RequestParam("confirmPassword") String confirmPassword){
        if (!user.getPassword().equals(confirmPassword)){
            return "redirect:/signup?error=passwordMismatch";
        }

        if (userService.isUsernameTaken(user.getUsername())){
            return "redirect:/signup?error=usernameTaken";
        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);

        userRepository.save(user);
        return "redirect:/signin";
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model){
        model.addAttribute("title", "Signup");
        return "signup";
    }

    @GetMapping("/signin")
    public String showLoginForm(Model model){
        model.addAttribute("title", "Login");
        return "login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Assuming "login" is the name of your Thymeleaf template for the login page
    }
}
