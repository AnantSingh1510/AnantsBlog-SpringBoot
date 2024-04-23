package com.testProjects.blog.services.Impl;

import com.testProjects.blog.models.Post;
import com.testProjects.blog.models.User;
import com.testProjects.blog.repositories.PostRepository;
import com.testProjects.blog.repositories.UserRepository;
import com.testProjects.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Post> findALlPosts() {
        List<Post> allPosts = postRepository.findAll();
//        if (allPosts.isEmpty()){
//            Post tempPost = new Post();
//            tempPost.setTitle("No posts yet");
//            tempPost.setContent("No posts found");
//
//            allPosts.add(tempPost);
//        }
        return allPosts;
    }

    @Override
    public Post savePost(Post post) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("User not found"));
        post.setAuthor(user);

        return postRepository.save(post);
    }

//    @Override
//    public List<Post> getPostsForCurrentUser() {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        return postRepository.findByUserUsername(username);
//    }

    @Override
    public Post findPostById(Long id) {
        return postRepository.findById(id).orElseThrow();
    }

    @Override
    public void deletePost(Long id) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username).orElseThrow();
        Post post = postRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Element not found"));

        if (post.getAuthor() == user){
            postRepository.deleteById(id);
        }
    }
}
