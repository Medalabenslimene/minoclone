package tn.esprit.donation.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "donations")

public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId; // nullable → anonymous donation

    @Column(name = "amount")
    private Double amount;

    @Column(name = "message")
    private String message;

    @Column(name = "anonymous")
    private Boolean anonymous;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private DonationStatus status;

    @Column(name = "payment_method")
    private String paymentMethod; // CARD, STRIPE, FAKE

    @Column(name = "donated_at")
    private LocalDateTime donatedAt;
}