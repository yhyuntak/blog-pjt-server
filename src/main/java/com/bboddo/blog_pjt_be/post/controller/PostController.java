package com.bboddo.blog_pjt_be.post.controller;


import com.bboddo.blog_pjt_be.post.dto.PostDTO;
import com.bboddo.blog_pjt_be.post.entity.Post;
import com.bboddo.blog_pjt_be.post.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@Slf4j
public class PostController {

    private PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDTO> getPostList(){
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostDTO getPost(@PathVariable Long postId){
        PostDTO foundPost = postService.getPost(postId);
        return foundPost;
    }

    @PostMapping
    public PostDTO addPost(@RequestBody PostDTO postDTO){
        PostDTO savedPostDTO = postService.createPost(postDTO);
        return savedPostDTO;
    }

    @PutMapping("/{postId}")
    public Boolean updatePost(@PathVariable Long postId, @RequestBody PostDTO postDTO){
        postDTO.setId(postId);
        return postService.updatePost(postDTO);
    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@PathVariable Long postId){
        postService.deletePost(postId);
    }

}
