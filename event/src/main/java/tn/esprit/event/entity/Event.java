package tn.esprit.event.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // ── Core Info ──────────────────────────────────────────
    @Column(name = "title")
    private String title;

    @Column(name = "description", length = 2000)
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "category")
    private String category;

    @ElementCollection
    @CollectionTable(name = "event_tags", joinColumns = @JoinColumn(name = "event_id"))
    @Column(name = "tag")
    private List<String> tags;

    // ── Scheduling ────────────────────────────────────────
    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "timezone")
    private String timezone;

    // ── Event Type (Online vs Outdoor) ────────────────────
    @Enumerated(EnumType.STRING)
    @Column(name = "event_type")
    private EventType eventType;

    @Column(name = "meeting_link")
    private String meetingLink;

    @Column(name = "platform")
    private String platform;

    @Column(name = "location")
    private String location;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    // ── Capacity & Attendance ─────────────────────────────
    @Column(name = "max_attendees")
    private Integer maxAttendees;

    @Column(name = "current_attendees")
    private Integer currentAttendees;

    @Column(name = "is_registration_open")
    private Boolean isRegistrationOpen;

    @Column(name = "registration_deadline")
    private LocalDateTime registrationDeadline;

    // ── Status & Visibility ───────────────────────────────
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EventStatus status;

    @Column(name = "is_featured")
    private Boolean isFeatured;

    @Column(name = "is_public")
    private Boolean isPublic;

    // ── Host / Organizer ──────────────────────────────────
    @Column(name = "host_name")
    private String hostName;

    @Column(name = "host_id")
    private Long hostId;

    @Column(name = "contact_email")
    private String contactEmail;

    // ── English Learning Specific ─────────────────────────
    @Column(name = "target_level")
    private String targetLevel;

    @Column(name = "skill_focus")
    private String skillFocus;

    // ── Metadata ──────────────────────────────────────────
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "price")
    private Double price;

    @Column(name = "is_free")
    private Boolean isFree;

}
