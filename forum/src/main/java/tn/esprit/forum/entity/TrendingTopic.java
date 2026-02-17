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
@Table(name = "trending_topics",
       indexes = {
           @Index(name = "idx_category", columnList = "category"),
           @Index(name = "idx_title", columnList = "title")
       })
public class TrendingTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;   // Grammar, TOEFL, Event...
    private String title;      // #PastParticiple, TOEFL Prep...

    @Builder.Default
    private Boolean isPinned = false;

    @Builder.Default
    private Integer viewCount = 0;

    @Builder.Default
    private Integer postCount = 0;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
