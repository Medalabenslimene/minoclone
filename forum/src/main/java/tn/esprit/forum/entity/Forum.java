package tn.esprit.forum.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "forum",
        indexes = {
                @Index(name = "idx_topic", columnList = "topicId"),
                @Index(name = "idx_user", columnList = "userId"),
                @Index(name = "idx_parent", columnList = "parentPostId")
        }
)
public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // References (microservice friendly – no ManyToOne)  
    private Long topicId;
    private Long userId;

    private String author;
    private String username;
    private String avatar;

    @Column(length = 2000, nullable = false)
    private String content;

    private String image;

    @Builder.Default
    private Boolean isEdited = false;

    // Self-reference for replies
    private Long parentPostId;

    @Builder.Default
    private Integer comments = 0;

    @Builder.Default
    private Integer reposts = 0;

    @Builder.Default
    private Integer likes = 0;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Automatically set timestamps when creating
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Automatically update timestamp when updating
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
