package com.testProjects.blog.services;

import com.testProjects.blog.models.Post;

import java.util.List;

public interface PostService {
    List<Post> findALlPosts();
    Post savePost(Post post);
//    List<Post> getPostsForCurrentUser();
    Post findPostById(Long id);
    void deletePost(Long id);
}
