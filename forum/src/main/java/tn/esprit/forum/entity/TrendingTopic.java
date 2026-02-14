package tn.esprit.forum.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "trending_topics")
public class TrendingTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long forumId;

    private String category;
    private String title;

    private String posts; // maybe rename to postsCount if numeric

    private Boolean isPinned = false;

    private Integer viewCount = 0;
    private Integer postCount = 0;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



    // Getters and Setters
}
