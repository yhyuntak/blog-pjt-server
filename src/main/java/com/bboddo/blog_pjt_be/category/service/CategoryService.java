package com.bboddo.blog_pjt_be.category.service;

import com.bboddo.blog_pjt_be.category.dto.CategoryChildDTO;
import com.bboddo.blog_pjt_be.category.dto.CategoryParentDTO;
import com.bboddo.blog_pjt_be.category.entity.CategoryChild;
import com.bboddo.blog_pjt_be.category.entity.CategoryParent;
import com.bboddo.blog_pjt_be.category.repository.CategoryChildRepository;
import com.bboddo.blog_pjt_be.category.repository.CategoryParentRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private CategoryParentRepository categoryParentRepository;
    private CategoryChildRepository categoryChildRepository;

    public CategoryService (CategoryParentRepository categoryParentRepository, CategoryChildRepository categoryChildRepository) {
        this.categoryParentRepository = categoryParentRepository;
        this.categoryChildRepository = categoryChildRepository;
    }

    public List<CategoryParentDTO> getAllCategoryParentsWithChildren() {
        List<CategoryParent> categoryParents = categoryParentRepository.findAllWithChildren();
        return categoryParents.stream()
                .sorted(Comparator.comparing(CategoryParent::getSort))
                .map(parent -> new CategoryParentDTO(
                        parent.getId(),
                        parent.getName(),
                        parent.getSort(),
                        parent.getCategoryChildren().stream()
                                .sorted(Comparator.comparing(CategoryChild::getSort))
                                .map(child -> new CategoryChildDTO(
                                        child.getId(),
                                        child.getName(),
                                        child.getSort()))
                                .collect(Collectors.toList())
                )).collect(Collectors.toList());
    }
}
