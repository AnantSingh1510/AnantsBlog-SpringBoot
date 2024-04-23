package com.testProjects.blog.controllers;

import com.testProjects.blog.models.Post;
import com.testProjects.blog.models.User;
import com.testProjects.blog.services.Impl.PostServiceImpl;
import com.testProjects.blog.services.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostServiceImpl postService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("post", new Post());
        return "create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Post post){
        postService.savePost(post);
        return "redirect:/";
    }

    @DeleteMapping("/{id}/delete")
    public String deletePost(@PathVariable("id") Long id){
        postService.deletePost(id);

        return "redirect:/";
    }
}
