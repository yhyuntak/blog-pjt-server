package com.bboddo.blog_pjt_be.post.repository;

import com.bboddo.blog_pjt_be.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findPostById(Long id);
}
