package com.bboddo.blog_pjt_be.category.dto;

import com.bboddo.blog_pjt_be.category.entity.CategoryChild;
import com.bboddo.blog_pjt_be.common.entity.AuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class CategoryParentDTO {
    private Long id;
    private String name;
    private Long sort;
    private List<CategoryChildDTO> categoryChildren = new ArrayList<>();
}
