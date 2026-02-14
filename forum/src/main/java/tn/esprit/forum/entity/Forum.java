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
@Table(name = "forum")
public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long topicId;  // can later become ManyToOne
    private Long userId;   // can later become ManyToOne(User)

    private String author;
    private String username;
    private String avatar;

    @Column(length = 2000)
    private String content;

    private String image;

    private Boolean isEdited;

    // Self reference for replies
    private Long parentPostId;

    private Integer comments = 0;
    private Integer reposts = 0;
    private Integer likes = 0;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    // Getters and Setters
}
