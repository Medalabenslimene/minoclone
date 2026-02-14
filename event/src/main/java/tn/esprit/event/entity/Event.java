package tn.esprit.event.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity

@Data

@AllArgsConstructor
@Builder
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    private LocalDate date;      // better than String
    private LocalTime time;      // better than String

    private String location;
    private String image;
    private String category;

    private Integer attendees;

    @Enumerated(EnumType.STRING)
    private EventStatus status;

    private String host;

    // tags: string[]
    @ElementCollection
    @CollectionTable(name = "event_tags", joinColumns = @JoinColumn(name = "event_id"))
    @Column(name = "tag")
    private List<String> tags;

    // Optional UI helper fields
    private String dayOfWeek;
    private String month;
    private Integer day;

    private Boolean isFeatured;
    private Boolean isLive;

    public Event() {
    }

    // Getters and Setters
}
