package tn.esprit.abonnement.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.time.LocalDateTime;
@Table(name = "usersubscriptions")

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long userId;

    @ManyToOne
    private SubscriptionPlan plan;

    private LocalDateTime subscribedAt;

    private LocalDateTime expiresAt;

    @Enumerated(EnumType.STRING)
    private SubscriptionStatus status;
}
