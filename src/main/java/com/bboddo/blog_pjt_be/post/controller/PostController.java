package com.bboddo.blog_pjt_be.post.controller;

import com.bboddo.blog_pjt_be.post.dto.PostDTO;
import com.bboddo.blog_pjt_be.post.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    public PostDTO getPost(@PathVariable String postId){
        PostDTO foundPost = postService.getPost(Long.parseLong(postId));
        return foundPost;
    }

    @PostMapping
    public PostDTO addPost(@RequestBody PostDTO postDTO){
        PostDTO savedPostDTO = postService.createPost(postDTO);
        return savedPostDTO;
    }

    @PutMapping("/{postId}")
    public Boolean updatePost(@PathVariable String postId, @RequestBody PostDTO postDTO){
        postDTO.setId(Long.parseLong(postId));
        return postService.updatePost(postDTO);
    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@PathVariable Long postId){
        postService.deletePost(postId);
    }

}
