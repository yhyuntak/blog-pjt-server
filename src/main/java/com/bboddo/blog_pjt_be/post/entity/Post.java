package com.bboddo.blog_pjt_be.post.entity;

import com.bboddo.blog_pjt_be.common.entity.AuditableEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "posts")
@EntityListeners(AuditingEntityListener.class)
public class Post extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Long userId;

    @Builder
    public Post(Long id, String title, String content, Long userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }
}
