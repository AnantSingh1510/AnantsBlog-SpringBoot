package com.testProjects.blog.controllers;

import com.testProjects.blog.models.Post;
import com.testProjects.blog.services.Impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class PublicController {
    @Autowired
    private PostServiceImpl postService;
    @GetMapping
    private String getAllPosts(Model model){
        List<Post> posts = postService.findALlPosts();
        Collections.sort(posts, (post1, post2) -> Long.compare(post2.getId(), post1.getId()));
        model.addAttribute("posts", posts);
        return "list";
    }
    @GetMapping("/posts")
    private String getAllPosts2(Model model){
        List<Post> posts = postService.findALlPosts();
        model.addAttribute("posts", posts);
        return "list";
    }

    @GetMapping("/posts/{id}")
    public String showPostById(@PathVariable("id") Long id, Model model){
        Post post = postService.findPostById(id);
        model.addAttribute("post", post);

        return "post";
    }
}
