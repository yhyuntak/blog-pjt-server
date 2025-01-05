package com.bboddo.blog_pjt_be.category.repository;

import com.bboddo.blog_pjt_be.category.entity.CategoryChild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryChildRepository extends JpaRepository<CategoryChild, Long> {
    List<CategoryChild> findByCategoryParentId(Long id);
}
