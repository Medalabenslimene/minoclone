



package tn.esprit.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String username;

    @Column(unique = true)
    private String email;

    private String pwd;
    private String numTel;

    private LocalDate dateNaiss;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean inscriptionOk;
    private boolean posterForum;

    private String avatar;

    // -------- TUTEUR fields --------
    private String CIN;
    private Integer yearsOfExperience;
    private String specialization;

    // -------- ADMIN fields --------
    private String departement;
    private String adminCIN;

    // -------- ETUDIANT fields --------
    private String level;
    private Integer xp;
    private Integer streak;
    private Integer coins;
    private String language;

    private LocalDate joinDate;

    @Column(length = 1000)
    private String bio;

    // Constructors
    public User() {
    }

    // Getters and Setters
}
