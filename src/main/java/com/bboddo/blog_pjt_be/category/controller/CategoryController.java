package com.bboddo.blog_pjt_be.category.controller;


import com.bboddo.blog_pjt_be.category.dto.CategoryParentDTO;
import com.bboddo.blog_pjt_be.category.entity.CategoryParent;
import com.bboddo.blog_pjt_be.category.service.CategoryService;
import com.bboddo.blog_pjt_be.post.dto.PostDTO;
import com.bboddo.blog_pjt_be.post.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {

    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/parents")
    public List<CategoryParentDTO> getAllCategoryParents() {
        return categoryService.getAllCategoryParentsWithChildren();
    }

}
