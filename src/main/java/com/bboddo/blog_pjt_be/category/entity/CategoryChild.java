package com.bboddo.blog_pjt_be.category.entity;

import com.bboddo.blog_pjt_be.common.entity.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "category_children")
@EntityListeners(AuditingEntityListener.class)
public class CategoryChild extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long sort;

    @ManyToOne
    @JoinColumn(name="parent_id")
    private CategoryParent categoryParent;
}
