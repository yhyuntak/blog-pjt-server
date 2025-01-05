package com.bboddo.blog_pjt_be.category.entity;

import com.bboddo.blog_pjt_be.common.entity.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "category_parents")
@EntityListeners(AuditingEntityListener.class)
public class CategoryParent extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long sort;

    @OneToMany(mappedBy = "categoryParent", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CategoryChild> categoryChildren = new ArrayList<>();
}
