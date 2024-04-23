package com.testProjects.blog.repositories;

import com.testProjects.blog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
//    List<Post> findByUserUsername(String username);
}
