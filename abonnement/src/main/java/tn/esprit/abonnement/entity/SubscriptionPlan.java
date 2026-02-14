package tn.esprit.abonnement.entity;

import jakarta.persistence.*;
import lombok.*;
@Table(name = "subscriptionplans")

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PlanType name; // FREEMIUM, STANDARD, PREMIUM

    private Double price;

    private Integer durationDays; // e.g. 30

    private String description;
}
