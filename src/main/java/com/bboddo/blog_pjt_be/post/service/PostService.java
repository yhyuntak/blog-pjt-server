package com.bboddo.blog_pjt_be.post.service;

import com.bboddo.blog_pjt_be.post.dto.PostDTO;
import com.bboddo.blog_pjt_be.post.entity.Post;
import com.bboddo.blog_pjt_be.post.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostDTO createPost(PostDTO postDTO) {

        Post post = Post.builder()
                .title(postDTO.getTitle())
                .content(postDTO.getContent())
                .userId(postDTO.getUserId())
                .build();

        Post saved = postRepository.save(post);

        PostDTO savedPostDTO = new PostDTO();
        savedPostDTO.setId(saved.getId());
        savedPostDTO.setTitle(saved.getTitle());
        savedPostDTO.setContent(saved.getContent());
        savedPostDTO.setUserId(saved.getUserId());
        return savedPostDTO;
    }

    public PostDTO getPost(Long postId) {
        Post postById = postRepository.findPostById(postId);
        PostDTO foundPostDTO = new PostDTO();
        foundPostDTO.setId(postById.getId());
        foundPostDTO.setTitle(postById.getTitle());
        foundPostDTO.setContent(postById.getContent());
        foundPostDTO.setUserId(postById.getUserId());
        foundPostDTO.setCreatedAt(postById.getCreatedAt());
        foundPostDTO.setCreatedBy(postById.getCreatedBy());
        foundPostDTO.setUpdatedAt(postById.getUpdatedAt());
        foundPostDTO.setUpdatedBy(postById.getUpdatedBy());
        return foundPostDTO;
    }

    public List<PostDTO> getAllPosts() {
        List<Post> postList = postRepository.findAll();
        List<PostDTO> postDTOList = new ArrayList<>();
        for (Post post : postList) {
            PostDTO postDTO = new PostDTO();
            postDTO.setId(post.getId());
            postDTO.setTitle(post.getTitle());
            postDTO.setContent(post.getContent());
            postDTO.setUserId(post.getUserId());
            postDTO.setCreatedAt(post.getCreatedAt());
            postDTO.setCreatedBy(post.getCreatedBy());
            postDTO.setUpdatedAt(post.getUpdatedAt());
            postDTO.setUpdatedBy(post.getUpdatedBy());
            postDTOList.add(postDTO);
        }
        return postDTOList;
    }

    public Boolean deletePost(Long postId) {
        try {
            Post postById = postRepository.findPostById(postId);
            postRepository.delete(postById);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean updatePost(PostDTO postDTO) {
        try {
            Post savedPost = postRepository.findPostById(postDTO.getId());
            Post changePost = Post.builder()
                    .id(savedPost.getId())
                    .title(postDTO.getTitle())
                    .content(postDTO.getContent())
                    .userId(postDTO.getUserId())
                    .build();
            postRepository.save(changePost);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
