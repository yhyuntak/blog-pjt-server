package com.bboddo.blog_pjt_be.category.repository;

import com.bboddo.blog_pjt_be.category.entity.CategoryParent;
import com.bboddo.blog_pjt_be.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryParentRepository extends JpaRepository<CategoryParent, Long> {

    @Query("SELECT p FROM CategoryParent p LEFT JOIN FETCH p.categoryChildren")
    List<CategoryParent> findAllWithChildren();

}
